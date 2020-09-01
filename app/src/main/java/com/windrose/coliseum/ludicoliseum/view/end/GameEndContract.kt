package com.windrose.coliseum.ludicoliseum.view.end

interface GameEndContract {
    interface Presenter {
        fun start()
    }

    interface View {
        fun setContent(winners: List<String>)
    }
}
