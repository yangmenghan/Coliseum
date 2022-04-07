package games.windrose.coliseum.view

import android.app.Application
import games.windrose.coliseum.core.di.CoreModule
import games.windrose.coliseum.data.di.DataModule
import games.windrose.coliseum.view.end.di.GameEndModule
import games.windrose.coliseum.view.game.di.GameModule
import games.windrose.coliseum.view.start.di.StartGameModule
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