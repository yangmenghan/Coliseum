package games.windrose.coliseum.view.utils

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import games.windrose.coliseum.R

class PlayerView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyle: Int = 0
) : CardView(context, attr, defStyle) {

    interface Listener {
        fun onKillPlayer(model: PlayerViewUiModel)
        fun onRoleRefresh(model: PlayerViewUiModel)
    }

    init {
        View.inflate(context, R.layout.view_player, this)
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        radius = 6.toPx().toFloat()
    }

    private lateinit var uiModel: PlayerViewUiModel
    private val characterNameView: TextView = findViewById(R.id.characterName)
    private val characterOriginView: TextView = findViewById(R.id.characterOrigin)
    private val roleRefreshButton: ImageButton = findViewById(R.id.role_refresh)
    private val killPlayerButton: ImageButton = findViewById(R.id.kill_player)
    var listener: Listener? = null

    fun showContent(model: PlayerViewUiModel) = with(model) {
        uiModel = this
        setCardBackgroundColor(resources.getColor(colorTheme.backgroundColor))
        characterNameView.apply {
            text = characterName
            setTextColor(resources.getColor(colorTheme.textColor))
            paintFlags = if (textStrikeThrough) paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            else paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
        characterOriginView.text = characterOrigin
        characterOriginView.setTextColor(resources.getColor(colorTheme.textColor))
        roleRefreshButton.apply {
            isVisible = isActionsVisible
            setOnClickListener { listener?.onRoleRefresh(uiModel) }
            imageTintList = resources.getColorStateList(colorTheme.iconColor)
        }
        killPlayerButton.apply {
            isVisible = isActionsVisible
            setOnClickListener { listener?.onKillPlayer(uiModel) }
            imageTintList = resources.getColorStateList(colorTheme.accentIconColor)
        }
    }

}

data class PlayerViewUiModel(
    val playerIndex: Int,
    val characterName: String,
    val characterOrigin: String?,
    val isActionsVisible: Boolean = true,
    val textStrikeThrough: Boolean,
    val colorTheme: ColorTheme,
) {
    sealed class ColorTheme(
        @ColorRes val backgroundColor: Int,
        @ColorRes val textColor: Int,
        @ColorRes val iconColor: Int,
        @ColorRes val accentIconColor: Int,
        @ColorRes val menuIconColor: Int,
    ) {
        class Default : ColorTheme(
            backgroundColor = R.color.white,
            textColor = R.color.vampireGrey,
            iconColor = R.color.vampireGrey,
            accentIconColor = R.color.cornellRed,
            menuIconColor = R.color.vampireGrey,
        )

        class Current : ColorTheme(
            backgroundColor = R.color.brownish,
            textColor = R.color.white,
            iconColor = R.color.supernovaDisabled,
            accentIconColor = R.color.supernovaDark,
            menuIconColor = R.color.white,
        )

        class Dead : ColorTheme(
            backgroundColor = R.color.supernovaDisabled,
            textColor = R.color.supernovaDark,
            iconColor = R.color.vampireGrey,
            accentIconColor = R.color.cornellRed,
            menuIconColor = R.color.vampireGrey,
        )

    }
}
