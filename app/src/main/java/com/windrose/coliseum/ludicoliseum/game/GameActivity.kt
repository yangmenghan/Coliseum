package com.windrose.coliseum.ludicoliseum.game

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.windrose.coliseum.ludicoliseum.R.layout

import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_game)
        setSupportActionBar(toolbar)

        nextFab.setOnClickListener { view ->
            Snackbar.make(view, "This is a next turn", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

}
