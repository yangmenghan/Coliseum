package com.windrose.coliseum.ludicoliseum.core

import com.windrose.coliseum.ludicoliseum.data.GameRepository
import com.windrose.coliseum.ludicoliseum.entity.Game
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.slot
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class CreateGameInteractorTest {

    @RelaxedMockK
    private lateinit var gameRepository: GameRepository
    private lateinit var createGame: CreateGameInteractor


    @Before
    fun setup() {
        MockKAnnotations.init(this)
        createGame = CreateGameInteractor(gameRepository)
    }

    @Test
    fun has_correct_players_number() {
        val slot = slot<Game>()
        every { gameRepository.setCurrentGame(capture(slot)) } answers {
            assertEquals(slot.captured.players.size, PLAYER_NUMBER)
        }
        createGame.create(PLAYER_NUMBER)
    }

    @Test
    fun current_player_is_first() {
        val slot = slot<Game>()
        every { gameRepository.setCurrentGame(capture(slot)) } answers {
            assertEquals(slot.captured.currentPlayer, 0)
        }
        createGame.create(PLAYER_NUMBER)
    }

    @Test
    fun players_have_distinct_character() {
        val slot = slot<Game>()
        every { gameRepository.setCurrentGame(capture(slot)) } answers {
            assertEquals(slot.captured.players.distinctBy { it.role }.size, PLAYER_NUMBER)
        }
        createGame.create(PLAYER_NUMBER)
    }

    @Test
    fun players_are_alive() {
        val slot = slot<Game>()
        every { gameRepository.setCurrentGame(capture(slot)) } answers {
            slot.captured.players.forEach { assertTrue(it.isAlive) }
        }
        createGame.create(PLAYER_NUMBER)
    }

    @Test
    fun roles_are_valid() = assertTrue(false)

    companion object {
        private const val PLAYER_NUMBER: Int = 5
    }
}
