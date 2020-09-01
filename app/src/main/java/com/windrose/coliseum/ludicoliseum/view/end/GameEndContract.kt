package com.windrose.coliseum.ludicoliseum.view.end

interface GameEndContract {
    interface Presenter {
        fun start()
        fun onRestart()
    }

    interface View {
        fun setContent(winners: List<String>)
    }

    interface Navigator {
        fun goStartGame()
    }
}
