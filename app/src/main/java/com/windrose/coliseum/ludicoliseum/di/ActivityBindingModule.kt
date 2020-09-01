package com.windrose.coliseum.ludicoliseum.di

import com.windrose.coliseum.ludicoliseum.view.HomeActivity
import com.windrose.coliseum.ludicoliseum.view.end.GameEndFragment
import com.windrose.coliseum.ludicoliseum.view.end.di.GameEndModule
import com.windrose.coliseum.ludicoliseum.view.game.GameFragment
import com.windrose.coliseum.ludicoliseum.view.game.di.GameModule
import com.windrose.coliseum.ludicoliseum.view.start.StartGameFragment
import com.windrose.coliseum.ludicoliseum.view.start.di.StartGameModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun bindGameActivity(): HomeActivity

    @ContributesAndroidInjector(modules = [StartGameModule::class])
    abstract fun bindStartGameFragment(): StartGameFragment

    @ContributesAndroidInjector(modules = [GameEndModule::class])
    abstract fun bindGameEndFragment(): GameEndFragment

    @ContributesAndroidInjector(modules = [GameModule::class])
    abstract fun bindGameFragment(): GameFragment
}
