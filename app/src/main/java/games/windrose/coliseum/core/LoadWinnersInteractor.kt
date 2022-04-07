package games.windrose.coliseum.core

import games.windrose.coliseum.data.GameRepository
import games.windrose.coliseum.entity.Player
import org.koin.core.annotation.Factory

@Factory
class LoadWinnersInteractor constructor(
    private val gameRepository: GameRepository
) {

    fun load(): List<Player> {
        val game = gameRepository.getCurrentGame()
        return game.players.filter { it.isAlive }
    }
}
