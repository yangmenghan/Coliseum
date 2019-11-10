package com.windrose.coliseum.ludicoliseum.view.start

import androidx.annotation.StringRes

interface StartGameContract {
    interface View {
        fun goToGame()
        fun showError(@StringRes errorTextId: Int)
    }

    interface Presenter {
        fun onCreateGame(playersNumber: Int?)
    }
}