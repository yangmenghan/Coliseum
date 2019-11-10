package com.windrose.coliseum.ludicoliseum.view.utils

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Switch
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.windrose.coliseum.ludicoliseum.R

class PlayerView @JvmOverloads constructor(
        context: Context,
        attr: AttributeSet? = null,
        defStyle: Int = 0
) : ConstraintLayout(context, attr, defStyle) {

    interface Listener {
        fun onAliveSwitchChange(isChecked: Boolean, model: PlayerViewUiModel)
    }

    init {
        View.inflate(context, R.layout.view_player, this)
    }

    private val indexTextView: TextView = findViewById(R.id.index)
    private val characterNameView: TextView = findViewById(R.id.characterName)
    private val characterOriginView: TextView = findViewById(R.id.characterOrigin)
    private val aliveSwitch: Switch = findViewById(R.id.aliveSwitch)
    var listener: Listener? = null

    fun showContent(model: PlayerViewUiModel) = with(model) {
        indexTextView.text = "#$playerIndex"
        characterNameView.text = characterName
        characterOriginView.text = characterOrigin
        aliveSwitch.isChecked = isAlive
        aliveSwitch.text = context.getString(aliveText)
        aliveSwitch.setOnCheckedChangeListener { _, isChecked -> listener?.onAliveSwitchChange(isChecked, model) }
    }
}

data class PlayerViewUiModel(
        val playerIndex: Int,
        val characterName: String,
        val characterOrigin: String?,
        @StringRes val aliveText: Int,
        val isAlive: Boolean = true,
        val isHighLighted: Boolean
)