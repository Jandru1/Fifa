package com.example.fifa.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.fifa.data.local.datasources.LocalDataSource
import com.example.fifa.data.local.Model.TeamLocal
import com.example.fifa.data.remote.RemoteDataSource
import com.example.fifa.data.remote.dto.TeamDto
import com.example.fifa.data.repositories.TeamRepositoryImpl
import com.example.fifa.testutils.DefaultDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule

import org.junit.Test

internal class TeamRepositoryImplTest {


    @get:Rule
    val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule: DefaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var localDataSource: LocalDataSource

    @MockK(relaxed = true)
    private lateinit var remoteDataSource: RemoteDataSource

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun getTeamListRemoteTest() = runTest{
        coEvery { localDataSource.getTeamList() } returns listOf<TeamLocal>()
        coEvery { remoteDataSource.getTeamList() } returns getTeamListRemote()

        val repo = TeamRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )
        val res = repo.getTeamList()

        assertThat(res.size, `is`(3))
        assertThat(res, instanceOf(List::class.java))
    }

    @Test
    fun getTeamListLocalTest() = runTest{
        coEvery { localDataSource.getTeamList() } returns getTeamListLocal()
        coEvery { remoteDataSource.getTeamList() } returns listOf<TeamDto>()

        val repo = TeamRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )
        val res = repo.getTeamList()

        assertThat(res.size, `is`(2))
        assertThat(res, instanceOf(List::class.java))
    }
}

fun getTeamListRemote() : List<TeamDto> = listOf<TeamDto>(
    TeamDto(2,"Premier", 5),
    TeamDto(2,"Premier", 5),
    TeamDto(2,"Premier", 5),
)

fun getTeamListLocal() : List<TeamLocal> = listOf<TeamLocal>(
    TeamLocal(2,"Premier", 5),
    TeamLocal(2,"Premier", 5),
)