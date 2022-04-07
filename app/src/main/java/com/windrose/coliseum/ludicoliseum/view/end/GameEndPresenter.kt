package com.windrose.coliseum.ludicoliseum.view.end

import com.windrose.coliseum.ludicoliseum.core.LoadWinnersInteractor
import org.koin.core.annotation.Factory

@Factory
class GameEndPresenter constructor(
    private val view: GameEndContract.View,
    private val loadWinners: LoadWinnersInteractor
) {

    fun start() {
        val winners = loadWinners.load()
        view.setContent(winners.map { it.role.name })
    }
}
