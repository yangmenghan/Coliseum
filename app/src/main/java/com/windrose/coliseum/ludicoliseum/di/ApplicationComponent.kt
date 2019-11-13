package com.windrose.coliseum.ludicoliseum.di

import android.app.Application
import android.content.Context
import com.windrose.coliseum.ludicoliseum.data.GameRepository
import com.windrose.coliseum.ludicoliseum.data.RoleRepository
import com.windrose.coliseum.ludicoliseum.data.RoleRepositoryImpl
import com.windrose.coliseum.ludicoliseum.data.game.SimpleGameRepositoryImpl
import com.windrose.coliseum.ludicoliseum.view.ColiseumApplication
import com.windrose.coliseum.ludicoliseum.view.game.di.GameModule
import com.windrose.coliseum.ludicoliseum.view.start.di.StartGameModule
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        StartGameModule::class,
        GameModule::class,
        ActivityBindingModule::class]
)
interface ApplicationComponent : AndroidInjector<ColiseumApplication> {

    @Component.Factory
    interface Builder : AndroidInjector.Factory<ColiseumApplication>
}

@Module
interface AppModule {

    @Binds
    fun application(app: ColiseumApplication): Application

    @Binds
    fun context(app: ColiseumApplication): Context

    @Singleton
    @Binds
    fun bindGameRepository(gameRepositoryImpl: SimpleGameRepositoryImpl): GameRepository

    @Singleton
    @Binds
    fun bindRoleRepository(repository: RoleRepositoryImpl): RoleRepository
}