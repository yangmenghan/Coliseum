package games.windrose.coliseum.view.end

interface GameEndContract {

    interface View {
        fun setContent(winners: List<String>)
    }
}
