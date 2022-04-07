package com.windrose.coliseum.ludicoliseum.view.end

interface GameEndContract {

    interface View {
        fun setContent(winners: List<String>)
    }
}
