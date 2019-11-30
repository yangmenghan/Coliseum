package com.windrose.coliseum.ludicoliseum.core

import com.windrose.coliseum.dataparser.models.Role
import com.windrose.coliseum.ludicoliseum.core.util.GetRandomElements
import com.windrose.coliseum.ludicoliseum.data.GameRepository
import com.windrose.coliseum.ludicoliseum.data.RoleRepository
import com.windrose.coliseum.ludicoliseum.utils.RoleRepositoryTestImpl
import io.mockk.CapturingSlot
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RoleReshuffleInteractorTest {

    @RelaxedMockK
    private lateinit var gameRepository: GameRepository
    private val game = TestGameGenerator.generate(listOf(true, true))

    private val roleRepository: RoleRepository = RoleRepositoryTestImpl()
    private lateinit var reshuffleInteractor: RoleReshuffleInteractor
    private var slot = CapturingSlot<Role>()

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        reshuffleInteractor = RoleReshuffleInteractor(gameRepository, roleRepository, GetRandomElements())

        every { gameRepository.getCurrentGame() } returns game
    }

    @Test
    fun new_role_is_different_from_old() {
        every { gameRepository.setPlayerRole(capture(slot), any()) } answers {
            Assert.assertNotEquals(game.players[0].role, slot.captured)
        }
        reshuffleInteractor.reshuffle(0)
    }

    @Test
    fun new_role_is_different_from_others() {
        every { gameRepository.setPlayerRole(capture(slot), any()) } answers {
            game.players.forEach { Assert.assertNotEquals(it.role, slot.captured) }
        }
        reshuffleInteractor.reshuffle(0)
    }
}
