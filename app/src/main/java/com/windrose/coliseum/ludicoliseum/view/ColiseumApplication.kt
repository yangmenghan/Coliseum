package com.windrose.coliseum.ludicoliseum.view

import android.app.Application
import com.windrose.coliseum.ludicoliseum.core.di.CoreModule
import com.windrose.coliseum.ludicoliseum.data.di.DataModule
import com.windrose.coliseum.ludicoliseum.view.end.di.GameEndModule
import com.windrose.coliseum.ludicoliseum.view.game.di.GameModule
import com.windrose.coliseum.ludicoliseum.view.start.di.StartGameModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class ColiseumApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ColiseumApplication)
            modules(
                CoreModule().module,
                DataModule().module,
                GameModule().module,
                GameEndModule().module,
                StartGameModule().module,
            )
        }
    }

}
