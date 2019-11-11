package com.windrose.coliseum.ludicoliseum.view.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.windrose.coliseum.ludicoliseum.R
import com.windrose.coliseum.ludicoliseum.R.layout
import com.windrose.coliseum.ludicoliseum.view.utils.PlayerView
import com.windrose.coliseum.ludicoliseum.view.utils.PlayerViewUiModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class GameFragment : DaggerFragment(), GameContract.View, PlayerView.Listener {
    @Inject
    lateinit var presenter: GameContract.Presenter

    private lateinit var playersListView: RecyclerView
    private lateinit var nextTurnButton: Button

    private val playersAdapter = PlayersAdapter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layout.fragment_game, container, false).apply {
            nextTurnButton = findViewById<Button>(R.id.nextTurnbutton).apply {
                setOnClickListener { presenter.onNextTurn() }
            }
            playersListView = findViewById(R.id.playersList)
            playersListView.adapter = playersAdapter
            presenter.start()
        }
    }

    override fun displayNewGame(model: GameUiModel) {
        playersAdapter.players = model.players
        playersListView.scrollToPosition(model.currentPlayer)
    }

    override fun showError(errorTextId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAliveSwitchChange(isChecked: Boolean, model: PlayerViewUiModel) =
            presenter.onCharacterAliveChanged(model.playerIndex, isChecked)

    companion object {
        fun newInstance() = GameFragment()
    }
}
