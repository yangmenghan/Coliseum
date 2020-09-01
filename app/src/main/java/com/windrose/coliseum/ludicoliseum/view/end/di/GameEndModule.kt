package com.windrose.coliseum.ludicoliseum.view.end.di

import com.windrose.coliseum.ludicoliseum.view.end.GameEndContract
import com.windrose.coliseum.ludicoliseum.view.end.GameEndFragment
import com.windrose.coliseum.ludicoliseum.view.end.GameEndPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class GameEndModule {

    @Binds
    abstract fun bindView(view: GameEndFragment): GameEndContract.View

    @Binds
    abstract fun bindPresenter(presenter: GameEndPresenter): GameEndContract.Presenter
}
