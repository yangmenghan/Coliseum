package games.windrose.coliseum.view.game

import games.windrose.coliseum.view.utils.PlayerViewUiModel

data class GameUiModel(
        val players: List<PlayerViewUiModel>,
        val currentPlayer: Int
)
