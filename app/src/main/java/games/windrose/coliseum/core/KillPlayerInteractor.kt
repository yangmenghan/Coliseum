package games.windrose.coliseum.core

import games.windrose.coliseum.data.GameRepository
import org.koin.core.annotation.Factory

@Factory
class KillPlayerInteractor constructor(private val gameRepository: GameRepository) {

    fun kill(playerIndex: Int) {
        val game = gameRepository.getCurrentGame()
        if (playerIndex < 0 || playerIndex >= game.players.size) return
        gameRepository.setPlayerAlive(false, playerIndex)
    }
}
