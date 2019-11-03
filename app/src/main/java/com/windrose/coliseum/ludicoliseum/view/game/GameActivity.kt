package com.windrose.coliseum.ludicoliseum.view.game

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

import com.windrose.coliseum.ludicoliseum.R.layout
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_game)

        nextFab.setOnClickListener { view ->
            Snackbar.make(view, "This is a next turn", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
