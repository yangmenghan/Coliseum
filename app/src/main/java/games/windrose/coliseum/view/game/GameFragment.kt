package games.windrose.coliseum.view.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import games.windrose.coliseum.R
import games.windrose.coliseum.view.start.StartGameFragment
import games.windrose.coliseum.view.utils.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class GameFragment : Fragment(), GameContract.View, PlayerView.Listener {

    private val presenter: GamePresenter by inject { parametersOf(this) }

    private lateinit var playersListView: RecyclerView
    private lateinit var nextTurnButton: ExtendedFloatingActionButton

    private val playersAdapter = PlayersAdapter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_game, container, false).apply {
            nextTurnButton = findViewById<ExtendedFloatingActionButton>(R.id.nextTurnButton).apply {
                setOnClickListener { presenter.onNextTurn() }
            }
            playersListView = findViewById(R.id.playersList)
            MarginItemDecoration(verticalSpaceSize = 8.toPx())
                .also {playersListView.addItemDecoration(it)}
            playersListView.adapter = playersAdapter
            presenter.start()
        }
    }

    override fun displayNewGame(model: GameUiModel) {
        playersListView.scrollToPosition(model.currentPlayer)
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
                .show()
        }
    }

    companion object {
        fun newInstance() = GameFragment()
    }
}
