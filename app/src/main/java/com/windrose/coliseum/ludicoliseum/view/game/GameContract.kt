package com.windrose.coliseum.ludicoliseum.view.game

import androidx.annotation.StringRes

interface GameContract {
    interface View {
        fun displayNewGame(model: GameUiModel)
        fun showError(@StringRes errorTextId: Int)
    }

    interface Navigator {
        fun goGameEnd()
    }
}
