package com.windrose.coliseum.ludicoliseum.view.game

import com.windrose.coliseum.ludicoliseum.view.utils.PlayerViewUiModel

data class GameUiModel(
        val players: List<PlayerViewUiModel>,
        val currentPlayer: Int
)