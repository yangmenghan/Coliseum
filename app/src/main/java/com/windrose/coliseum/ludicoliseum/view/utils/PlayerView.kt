package com.windrose.coliseum.ludicoliseum.view.utils

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
        fun onRoleRefresh(model: PlayerViewUiModel)
    }

    init {
        View.inflate(context, R.layout.view_player, this)
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    private lateinit var uiModel: PlayerViewUiModel
    private val indexTextView: TextView = findViewById(R.id.index)
    private val characterNameView: TextView = findViewById(R.id.characterName)
    private val characterOriginView: TextView = findViewById(R.id.characterOrigin)
    private val roleRefreshButton: ImageView = findViewById(R.id.role_refresh)
    private val aliveSwitch: Switch = findViewById(R.id.aliveSwitch)
    var listener: Listener? = null

    fun showContent(model: PlayerViewUiModel) = with(model) {
        uiModel = this
        indexTextView.text = "#${playerIndex + 1}"
        characterNameView.text = characterName
        characterOriginView.text = characterOrigin
        setState(isAlive, isHighLighted)
        roleRefreshButton.setOnClickListener { listener?.onRoleRefresh(uiModel) }
        aliveSwitch.text = context.getString(aliveText)
        aliveSwitch.setOnCheckedChangeListener(null)
        if (aliveSwitch.isChecked != isAlive) aliveSwitch.isChecked = isAlive
        aliveSwitch.setOnCheckedChangeListener { _, isChecked -> listener?.onAliveSwitchChange(isChecked, uiModel) }
    }

    private fun setState(alive: Boolean, highLighted: Boolean) {
        if (!alive) {
            setBackgroundColor(resources.getColor(R.color.deadBackgroundColor))
        } else if (highLighted) {
            setBackgroundColor(resources.getColor(R.color.highlightBackgroundcolor))
        } else {
            setBackgroundColor(resources.getColor(android.R.color.white))
        }
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
