package com.windrose.coliseum.ludicoliseum.view.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.windrose.coliseum.ludicoliseum.R
import com.windrose.coliseum.ludicoliseum.view.game.GameFragment
import com.windrose.coliseum.ludicoliseum.view.utils.routeToFragment
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class StartGameFragment : Fragment(), StartGameContract.View {

    private val presenter: StartGamePresenter by inject { parametersOf(this) }

    private lateinit var playersNumberInput: EditText
    private lateinit var createGameButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_game_start, container, false).apply {
            playersNumberInput = findViewById(R.id.playersNumberInput)
            createGameButton = findViewById(R.id.createGameButton)
            createGameButton.setOnClickListener { presenter.onCreateGame(playersNumberInput.text.toString().toIntOrNull()) }
        }
    }

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
