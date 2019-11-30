package com.windrose.coliseum.ludicoliseum.core

import com.windrose.coliseum.ludicoliseum.data.GameRepository
import com.windrose.coliseum.ludicoliseum.entity.Game
import com.windrose.coliseum.ludicoliseum.utils.TestGameGenerator
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class NextTurnInteractorTest {

    @RelaxedMockK
    private lateinit var gameRepository: GameRepository
    private lateinit var nextTurnInteractor: NextTurnInteractor

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        nextTurnInteractor = NextTurnInteractor(gameRepository)

    }

    @Test
    fun after_first_players_turn() {
        val game = TestGameGenerator.generate(listOf(true, true, true))
        every { gameRepository.getCurrentGame() } returns game

        nextTurnInteractor.nextTurn()
        verify { gameRepository.setCurrentPlayer(1) }
    }

    @Test
    fun after_last_players_turn() {
        val game = TestGameGenerator.generate(listOf(true, true), 1)
        every { gameRepository.getCurrentGame() } returns game

        nextTurnInteractor.nextTurn()
        verify { gameRepository.setCurrentPlayer(0) }
    }

    @Test
    fun after_last_turn() {
        val game = TestGameGenerator.generate(listOf(true, false, false))
        every { gameRepository.getCurrentGame() } returns game

        nextTurnInteractor.nextTurn()
        verify { gameRepository.setCurrentPlayer(Game.CURRENT_PLAYER_AT_GAME_END) }
    }
}
