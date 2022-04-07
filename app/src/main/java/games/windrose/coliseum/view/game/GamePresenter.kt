package games.windrose.coliseum.view.game

import games.windrose.coliseum.R
import games.windrose.coliseum.core.KillPlayerInteractor
import games.windrose.coliseum.core.NextTurnInteractor
import games.windrose.coliseum.core.RoleReshuffleInteractor
import games.windrose.coliseum.data.GameRepository
import games.windrose.coliseum.entity.Game
import games.windrose.coliseum.entity.Player
import games.windrose.coliseum.view.utils.PlayerViewUiModel
import org.koin.core.annotation.Factory

@Factory
class GamePresenter constructor(
    private val view: GameContract.View,
    private val navigator: GameContract.Navigator,
    private val nextTurnInteractor: NextTurnInteractor,
    private val killPlayerInteractor: KillPlayerInteractor,
    private val roleReshuffleInteractor: RoleReshuffleInteractor,
    private val gameRepository: GameRepository,
    private val mapper: GameUiModelMapper
) {

    fun start() {
        refreshDisplay()
    }

    private fun refreshDisplay() {
        val game = gameRepository.getCurrentGame()
        when (game.currentPlayer) {
            Game.CURRENT_PLAYER_AT_GAME_END -> navigator.goGameEnd()
            else -> view.displayNewGame(mapper.map(game))
        }
    }

    fun onNextTurn() {
        nextTurnInteractor.nextTurn()
        refreshDisplay()
    }

    fun onCharacterAliveChanged(playerIndex: Int, isAlive: Boolean) {
        if (!isAlive) killPlayerInteractor.kill(playerIndex)
        refreshDisplay()
    }

    fun onCharacterRoleRefresh(playerIndex: Int) {
        roleReshuffleInteractor.reshuffle(playerIndex)
        refreshDisplay()
    }
}

@Factory
class GameUiModelMapper {
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