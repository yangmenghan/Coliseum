package com.windrose.coliseum.ludicoliseum.view.end

import javax.inject.Inject

class GameEndPresenter @Inject constructor(
    private val view: GameEndContract.View,
    private val loadWinners: LoadWinnersInteractor
) : GameEndContract.Presenter {

    override fun start() {
        val winners = loadWinners.load()
        view.setContent(winners)
    }
}
