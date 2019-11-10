package com.windrose.coliseum.ludicoliseum.view.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.windrose.coliseum.ludicoliseum.R
import javax.inject.Inject

class StartGameFragment : Fragment(), StartGameContract.View {

    @Inject
    private lateinit var presenter: StartGameContract.Presenter

    private lateinit var playersNumberInput: EditText
    private lateinit var createGameButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_start_game, container).apply {
            playersNumberInput = findViewById(R.id.playersNumberInput)
            createGameButton = findViewById(R.id.createGameButton)
            createGameButton.setOnClickListener { presenter.onCreateGame(playersNumberInput.text.toString().toIntOrNull()) }
        }
    }

    override fun goToGame() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(errorTextId: Int) {
        playersNumberInput.error = getString(R.string.start_game_players_number_error)
    }

    companion object Factory {
        fun newInstance() = StartGameFragment()
    }
}