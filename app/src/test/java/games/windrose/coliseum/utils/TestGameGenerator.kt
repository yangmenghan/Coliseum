package games.windrose.coliseum.utils

import games.windrose.coliseum.dataparser.models.Role
import games.windrose.coliseum.entity.Game
import games.windrose.coliseum.entity.Player

object TestGameGenerator {

    fun generate(aliveStatus: List<Boolean>, currentPlayer: Int = 0) = Game(aliveStatus.mapIndexed { index, isAlive ->
        Player(role = Role(id = index, name = "test", origin = "Test Origin"), isAlive = isAlive)
    }, currentPlayer)
}
