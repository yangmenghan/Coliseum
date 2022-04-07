package com.windrose.coliseum.view.end

interface GameEndContract {

    interface View {
        fun setContent(winners: List<String>)
    }
}
