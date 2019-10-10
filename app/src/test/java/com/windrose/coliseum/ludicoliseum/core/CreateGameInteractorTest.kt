package com.windrose.coliseum.ludicoliseum.core

import com.windrose.coliseum.ludicoliseum.entity.Game
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class CreateGameInteractorTest {

    private val createGame = CreateGameInteractor()
    private lateinit var game: Game

    @Before
    fun setup() {
        game = createGame.create(PLAYER_NUMBER)
    }

    @Test
    fun has_correct_players_number() = assertEquals(game.players.size, PLAYER_NUMBER)

    @Test
    fun current_player_is_first() = assertEquals(game.currentPlayer, 0)


    @Test
    fun players_have_distinct_character() = assertEquals(game.players.distinctBy { it.character }.size, PLAYER_NUMBER)

    @Test
    fun players_are_alive() = game.players.forEach { assertTrue(it.isAlive) }

    @Test
    fun roles_are_valid() = assertTrue(false)

    companion object {
        private const val PLAYER_NUMBER: Int = 5
    }
}