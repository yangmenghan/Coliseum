package com.windrose.coliseum.ludicoliseum.view.game.di

import com.windrose.coliseum.ludicoliseum.view.game.GameContract
import com.windrose.coliseum.ludicoliseum.view.game.GameFragment
import com.windrose.coliseum.ludicoliseum.view.game.GamePresenter
import dagger.Binds
import dagger.Module

@Module
abstract class GameModule {

    @Binds
    abstract fun bindsView(view: GameFragment): GameContract.View

    @Binds
    abstract fun bindsNavigator(navigator: GameFragment): GameContract.Navigator

    @Binds
    abstract fun bindsPresenter(presenter: GamePresenter): GameContract.Presenter
}
