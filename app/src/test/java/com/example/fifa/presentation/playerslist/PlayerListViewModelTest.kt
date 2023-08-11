package com.example.fifa.presentation.playerslist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.fifa.testbuilders.PlayerTestDataBuilder
import com.example.fifa.domain.usecases.GetPlayersListUseCase
import com.example.fifa.testutils.DefaultDispatcherRule
import com.example.fifa.testutils.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule

import org.junit.Test

internal class PlayerListViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var getPlayersListUseCase: GetPlayersListUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun getPlayersList() = runTest{
        coEvery { getPlayersListUseCase.invoke(4) } returns PlayerTestDataBuilder().withNumElements(10).buildList()

        val vm = PlayerListViewModel(getPlayersListUseCase)

        val res = vm.playersList.getOrAwaitValue()

        assertThat(res.size, `is`(10))
    }
}