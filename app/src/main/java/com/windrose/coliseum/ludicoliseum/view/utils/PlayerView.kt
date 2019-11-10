package com.windrose.coliseum.ludicoliseum.view.utils

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Switch
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.windrose.coliseum.ludicoliseum.R

class PlayerView(context: Context, attr: AttributeSet?, defStyle: Int) : ConstraintLayout(context, attr, defStyle) {

    interface Listener {
        fun onSwitchChange(isChecked: Boolean)
    }

    init {
        View.inflate(context, R.layout.view_player, this)
    }

    private val indexTextView: TextView = findViewById(R.id.index)
    private val characterNameView: TextView = findViewById(R.id.characterName)
    private val characterOriginView: TextView = findViewById(R.id.characterOrigin)
    private val aliveSwitch: Switch = findViewById(R.id.aliveSwitch)
    private var listener: Listener? = null

    fun showContent(model: PlayerViewUiModel) = with(model) {
        indexTextView.text = "#$playerIndex"
        characterNameView.text = characterName
        characterOriginView.text = characterOrigin
        aliveSwitch.isChecked = isAlive
        aliveSwitch.text = aliveText
        aliveSwitch.setOnCheckedChangeListener { _, isChecked -> listener?.onSwitchChange(isChecked) }
    }
}

data class PlayerViewUiModel(
        val playerIndex: String,
        val characterName: String,
        val characterOrigin: String,
        val aliveText: String,
        val isAlive: Boolean = true
)