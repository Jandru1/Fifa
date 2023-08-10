package com.example.fifa.presentation.teamlist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.fifa.TeamTestDataBuilder
import com.example.fifa.domain.usecases.GetTeamsListUseCase
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
import org.junit.jupiter.api.Assertions.*

import org.junit.Test
import org.koin.androidx.compose.get

internal class TeamListViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var getTeamListUseCase: GetTeamsListUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun getTeamList() = runTest{
        coEvery { getTeamListUseCase.invoke() } returns TeamTestDataBuilder().withNumElements(10).buildList()

        val vm = TeamListViewModel(getTeamListUseCase)

        val res = vm.teamList.getOrAwaitValue()

        assertThat(res.size, `is`(10))
    }
}