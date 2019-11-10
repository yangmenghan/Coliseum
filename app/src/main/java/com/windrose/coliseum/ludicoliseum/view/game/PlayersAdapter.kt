package com.windrose.coliseum.ludicoliseum.view.game

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.windrose.coliseum.ludicoliseum.view.utils.PlayerView
import com.windrose.coliseum.ludicoliseum.view.utils.PlayerViewUiModel
import kotlin.properties.Delegates

class PlayersAdapter(private val listener: PlayerView.Listener) : RecyclerView.Adapter<PlayerViewHolder>() {

    var players: List<PlayerViewUiModel> by Delegates.observable(listOf()) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PlayerViewHolder(PlayerView(parent.context))

    override fun getItemCount() = players.count()

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) = holder.bind(players[position], listener)

}

class PlayerViewHolder(private val playerView: PlayerView) : RecyclerView.ViewHolder(playerView) {

    fun bind(model: PlayerViewUiModel, listener: PlayerView.Listener) {
        playerView.showContent(model)
        playerView.listener = listener
    }
}
