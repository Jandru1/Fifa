package com.example.fifa.presentation.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.fifa.testbuilders.PlayerTestDataBuilder
import com.example.fifa.domain.usecases.GetPlayerDetailUseCase
import com.example.fifa.testutils.DefaultDispatcherRule
import com.example.fifa.testutils.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule

import org.junit.Test

internal class PlayerDetailViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var getHeroDetailUseCase: GetPlayerDetailUseCase //Mock: modelo de prueba que te creas del use case

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun get_player() {
        coEvery { getHeroDetailUseCase.invoke(3) } returns
                PlayerTestDataBuilder().builder()

        val viewModel = PlayerDetailViewModel(getHeroDetailUseCase)

        viewModel.getPlayer(3)

        val res = viewModel.player.getOrAwaitValue()

        assertThat(res.id, `is`(3))
    }
}