package com.windrose.coliseum.view.game

import com.windrose.coliseum.view.utils.PlayerViewUiModel

data class GameUiModel(
        val players: List<PlayerViewUiModel>,
        val currentPlayer: Int
)
