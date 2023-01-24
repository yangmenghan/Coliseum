package games.windrose.coliseum.view.start

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import games.windrose.coliseum.R
import games.windrose.coliseum.view.game.GameFragment
import games.windrose.coliseum.view.utils.routeToFragment
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class StartGameFragment : Fragment(), StartGameContract.View {

    private val presenter: StartGamePresenter by inject { parametersOf(this) }

    private lateinit var playersNumberInput: EditText
    private lateinit var createGameButton: ImageButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_game_start, container, false).apply {
            playersNumberInput = findViewById(R.id.playersNumberInput)
            playersNumberInput.setOnEditorActionListener { _, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_DONE
                    || event.action == KeyEvent.ACTION_DOWN
                    && event.keyCode == KeyEvent.KEYCODE_ENTER) {
                    onCreateGameClicked()
                    true
                } else {
                    false
                }
            }
            createGameButton = findViewById(R.id.createGameButton)
            createGameButton.setOnClickListener { onCreateGameClicked() }
        }
    }

    private fun onCreateGameClicked() =
        presenter.onCreateGame(playersNumberInput.text.toString().toIntOrNull())

    override fun goToGame() {
        routeToFragment(GameFragment.newInstance())
    }

    override fun showError(errorTextId: Int) {
        playersNumberInput.error = getString(R.string.start_game_players_number_error)
    }

    companion object Factory {
        fun newInstance() = StartGameFragment()
    }
}
