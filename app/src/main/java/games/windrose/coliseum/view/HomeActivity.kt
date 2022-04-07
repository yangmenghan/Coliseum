package games.windrose.coliseum.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import games.windrose.coliseum.R
import games.windrose.coliseum.view.start.StartGameFragment
import games.windrose.coliseum.view.utils.routeToFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        routeToFragment(StartGameFragment.newInstance())
    }
}
