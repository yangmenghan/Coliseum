package games.windrose.coliseum.view.utils

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.StringRes
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
        characterNameView.text = characterName
        characterOriginView.text = characterOrigin
        setState(isAlive, isHighLighted)
        roleRefreshButton.setOnClickListener { listener?.onRoleRefresh(uiModel) }
        killPlayerButton.isVisible = isAlive
        killPlayerButton.setOnClickListener {
            listener?.onKillPlayer(uiModel)
        }
    }

    private fun setState(alive: Boolean, highLighted: Boolean) {
        if (!alive) {
            setCardBackgroundColor(resources.getColor(R.color.deadBackgroundColor))
        } else if (highLighted) {
            setCardBackgroundColor(resources.getColor(R.color.highlightBackgroundcolor))
        } else {
            setCardBackgroundColor(resources.getColor(android.R.color.white))
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
