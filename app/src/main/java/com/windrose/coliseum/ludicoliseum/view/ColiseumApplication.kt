package com.windrose.coliseum.ludicoliseum.view

import android.app.Application
import com.windrose.coliseum.ludicoliseum.di.DaggerApplicationComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class ColiseumApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Any>

    override fun androidInjector() = injector

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.builder().build().inject(this)
    }
}