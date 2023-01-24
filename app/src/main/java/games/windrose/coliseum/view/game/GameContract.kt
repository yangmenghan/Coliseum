package games.windrose.coliseum.view.game

import androidx.annotation.StringRes

interface GameContract {
    interface View {
        fun displayNewGame(model: GameUiModel)
        fun showError(@StringRes errorTextId: Int)
    }
}
