package com.windrose.coliseum.view.start

import androidx.annotation.StringRes

interface StartGameContract {
    interface View {
        fun goToGame()
        fun showError(@StringRes errorTextId: Int)
    }
}
