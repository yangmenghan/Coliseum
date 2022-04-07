package com.windrose.coliseum.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.windrose.coliseum.R
import com.windrose.coliseum.view.start.StartGameFragment
import com.windrose.coliseum.view.utils.routeToFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        routeToFragment(StartGameFragment.newInstance())
    }
}
