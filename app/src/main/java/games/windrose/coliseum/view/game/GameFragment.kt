package games.windrose.coliseum.view.game

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import games.windrose.coliseum.R
import games.windrose.coliseum.view.start.StartGameFragment
import games.windrose.coliseum.view.utils.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class GameFragment : Fragment(), GameContract.View, PlayerView.Listener {

    private val presenter: GamePresenter by inject { parametersOf(this) }

    private lateinit var playersListView: RecyclerView
    private lateinit var nextTurnButton: ExtendedFloatingActionButton
    private lateinit var restartButton: FloatingActionButton

    private val playersAdapter = PlayersAdapter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_game, container, false).apply {
            nextTurnButton = findViewById<ExtendedFloatingActionButton>(R.id.nextTurnButton).apply {
                setOnClickListener { presenter.onNextTurn() }
            }
            restartButton = findViewById<FloatingActionButton>(R.id.restartButton).apply {
                setOnClickListener {
                    context?.let { showConfirmRestartDialog(it) }
                }
            }
            playersListView = findViewById(R.id.playersList)
            MarginItemDecoration(verticalSpaceSize = 8.toPx())
                .also {playersListView.addItemDecoration(it)}
            playersListView.adapter = playersAdapter
            presenter.start()
        }
    }

    private fun FloatingActionButton.showConfirmRestartDialog(context: Context) {
        MaterialAlertDialogBuilder(context)
            .setTitle(resources.getString(R.string.game_restart_confirm_title))
            .setMessage(resources.getString(R.string.game_restart_confirm_message))
            .setPositiveButton(resources.getString(android.R.string.ok)) { _, _ ->
                routeToFragment(StartGameFragment.newInstance())
            }
            .setNegativeButton(resources.getString(android.R.string.cancel)) { _, _ -> }
            .show()
    }

    override fun displayNewGame(model: GameUiModel) {
        if (model.shouldScrollToCurrent) playersListView.scrollToPosition(model.currentPlayer)
        playersListView.post {
            playersAdapter.players = model.players
        }
        model.winners?.let { showGameEnd(it) }
    }

    override fun showError(errorTextId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onKillPlayer(model: PlayerViewUiModel) =
        presenter.onCharacterAliveChanged(model.playerIndex)

    override fun onRoleRefresh(model: PlayerViewUiModel) =
        presenter.onCharacterRoleRefresh(model.playerIndex)

    private fun showGameEnd(winners: List<String>) {
        context?.let { context ->
            MaterialAlertDialogBuilder(context)
                .setTitle(resources.getString(R.string.game_finished))
                .setMessage(resources.getQuantityString(R.plurals.survivors, winners.size, winners))
                .setPositiveButton(resources.getString(R.string.restart_game)) { _, _ ->
                    routeToFragment(StartGameFragment.newInstance())
                }
                .setCancelable(false)
                .show()
        }
    }

    companion object {
        fun newInstance() = GameFragment()
    }
}
