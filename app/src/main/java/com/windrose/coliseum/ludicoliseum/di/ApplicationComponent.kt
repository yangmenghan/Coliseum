package com.windrose.coliseum.ludicoliseum.di

import android.app.Activity
import android.app.Application
import com.windrose.coliseum.ludicoliseum.view.ColiseumApplication
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector


@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBindingModule::class])
interface ApplicationComponent: AndroidInjector<Activity> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: ColiseumApplication)
}

@Module
interface AppModule {}