package com.windrose.coliseum.ludicoliseum.view.start.di

import com.windrose.coliseum.ludicoliseum.view.start.StartGameContract
import com.windrose.coliseum.ludicoliseum.view.start.StartGameFragment
import com.windrose.coliseum.ludicoliseum.view.start.StartGamePresenter
import dagger.Binds
import dagger.Module

@Module
abstract class StartGameModule {

    @Binds
    abstract fun bindView(view: StartGameFragment): StartGameContract.View

    @Binds
    abstract fun bindPresenter(presenter: StartGamePresenter): StartGameContract.Presenter
}