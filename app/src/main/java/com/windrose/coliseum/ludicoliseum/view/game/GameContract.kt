package com.windrose.coliseum.ludicoliseum.view.game

import androidx.annotation.StringRes

interface GameContract {
    interface View {
        fun displayNewGame(model: GameUiModel)
        fun showError(@StringRes errorTextId: Int)
    }

    interface Presenter {
        fun start()
        fun onCharacterAliveChanged(playerIndex: Int, isAlive: Boolean)
        fun onNextTurn()
    }
}