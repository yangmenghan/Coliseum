package com.windrose.coliseum.ludicoliseum.core

import com.windrose.coliseum.ludicoliseum.data.GameRepository
import com.windrose.coliseum.ludicoliseum.utils.TestGameGenerator
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class KillPlayerInteractorTest {

    @RelaxedMockK
    private lateinit var gameRepository: GameRepository
    private lateinit var killPlayer: KillPlayerInteractor

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        killPlayer = KillPlayerInteractor(gameRepository)
    }

    @Test
    fun killOne() {
        val game = TestGameGenerator.generate(listOf(true, true))
        every { gameRepository.getCurrentGame() } returns game

        val index = 1
        killPlayer.kill(index)
        verify { gameRepository.setPlayerAlive(false, index) }
    }

    @Test
    fun killCurrent() {
        val game = TestGameGenerator.generate(listOf(true, true))
        every { gameRepository.getCurrentGame() } returns game

        val index = game.currentPlayer
        killPlayer.kill(index)
        verify { gameRepository.setPlayerAlive(false, index) }
    }

    @Test
    fun killAlreadyDead() {
        val game = TestGameGenerator.generate(listOf(true, false))
        every { gameRepository.getCurrentGame() } returns game

        val index = 1
        killPlayer.kill(index)
        verify { gameRepository.setPlayerAlive(false, index) }
    }
}
