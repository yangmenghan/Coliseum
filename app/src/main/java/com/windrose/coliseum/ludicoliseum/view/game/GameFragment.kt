package com.windrose.coliseum.ludicoliseum.view.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.windrose.coliseum.ludicoliseum.R.layout

/**
 * A placeholder fragment containing a simple view.
 */
class GameFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layout.fragment_game, container, false)
    }
}