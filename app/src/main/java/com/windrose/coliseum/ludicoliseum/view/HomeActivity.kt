package com.windrose.coliseum.ludicoliseum.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.windrose.coliseum.ludicoliseum.R
import com.windrose.coliseum.ludicoliseum.view.start.StartGameFragment
import com.windrose.coliseum.ludicoliseum.view.utils.routeToFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        routeToFragment(StartGameFragment.newInstance())
    }
}