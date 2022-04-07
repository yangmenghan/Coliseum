package com.windrose.coliseum.view.start

import com.windrose.coliseum.R
import com.windrose.coliseum.core.CreateGameInteractor
import org.koin.core.annotation.Factory

@Factory
class StartGamePresenter(
        private val view: StartGameContract.View,
        private val createGame: CreateGameInteractor
) {

    fun onCreateGame(playersNumber: Int?) {
        if (playersNumber == null) {
            view.showError(R.string.start_game_players_number_error)
        } else {
            createGame.create(playersNumber)
            view.goToGame()
        }
    }
}
