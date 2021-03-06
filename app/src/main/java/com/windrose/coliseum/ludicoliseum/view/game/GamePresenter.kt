package com.windrose.coliseum.ludicoliseum.view.game

import com.windrose.coliseum.ludicoliseum.R
import com.windrose.coliseum.ludicoliseum.core.KillPlayerInteractor
import com.windrose.coliseum.ludicoliseum.core.NextTurnInteractor
import com.windrose.coliseum.ludicoliseum.core.RoleReshuffleInteractor
import com.windrose.coliseum.ludicoliseum.data.GameRepository
import com.windrose.coliseum.ludicoliseum.entity.Game
import com.windrose.coliseum.ludicoliseum.entity.Player
import com.windrose.coliseum.ludicoliseum.view.utils.PlayerViewUiModel
import javax.inject.Inject

class GamePresenter @Inject constructor(
    private val view: GameContract.View,
    private val navigator: GameContract.Navigator,
    private val nextTurnInteractor: NextTurnInteractor,
    private val killPlayerInteractor: KillPlayerInteractor,
    private val roleReshuffleInteractor: RoleReshuffleInteractor,
    private val gameRepository: GameRepository,
    private val mapper: GameUiModelMapper
) : GameContract.Presenter {

    override fun start() {
        refreshDisplay()
    }

    private fun refreshDisplay() {
        val game = gameRepository.getCurrentGame()
        when (game.currentPlayer) {
            Game.CURRENT_PLAYER_AT_GAME_END -> navigator.goGameEnd()
            else -> view.displayNewGame(mapper.map(game))
        }
    }

    override fun onNextTurn() {
        nextTurnInteractor.nextTurn()
        refreshDisplay()
    }

    override fun onCharacterAliveChanged(playerIndex: Int, isAlive: Boolean) {
        if (!isAlive) killPlayerInteractor.kill(playerIndex)
        refreshDisplay()
    }

    override fun onCharacterRoleRefresh(playerIndex: Int) {
        roleReshuffleInteractor.reshuffle(playerIndex)
        refreshDisplay()
    }
}

class GameUiModelMapper @Inject constructor() {
    fun map(game: Game): GameUiModel = GameUiModel(
        game.players.mapIndexed { i, it -> mapPlayer(i, it, game.currentPlayer) },
        game.currentPlayer
    )

    private fun mapPlayer(index: Int, player: Player, currentPlayer: Int) = PlayerViewUiModel(
        playerIndex = index,
        characterName = player.role.name,
        characterOrigin = player.role.origin,
        aliveText = getAliveText(player.isAlive),
        isAlive = player.isAlive,
        isHighLighted = currentPlayer == index
    )

    private fun getAliveText(alive: Boolean) = if (alive) R.string.game_player_alive else R.string.game_player_dead
}
