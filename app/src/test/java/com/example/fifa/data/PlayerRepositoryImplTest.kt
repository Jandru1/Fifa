package com.example.fifa.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.fifa.data.local.LocalDataSource
import com.example.fifa.data.local.Model.PlayerLocal
import com.example.fifa.data.remote.RemoteDataSource
import com.example.fifa.data.remote.dto.PlayerDto
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
import org.junit.jupiter.api.Assertions.*

import org.junit.Test

internal class PlayerRepositoryImplTest {

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
    fun getPlayersList() = runTest {
        coEvery { localDataSource.getPlayerList(3) } returns listOf<PlayerLocal>()
        coEvery { remoteDataSource.getPlayersList() } returns getPlayerListRemote()

        val repo = PlayerRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val res = repo.getPlayersList(3)

        assertThat(res, instanceOf(List::class.java))
        assertThat(res.size, `is`(3))
    }
    @Test
    fun getPlayersList2() = runTest {
        coEvery { localDataSource.getPlayerList(3) } returns getPlayerListLocal()
        coEvery { remoteDataSource.getPlayersList() } returns listOf<PlayerDto>()

        val repo = PlayerRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val res = repo.getPlayersList(3)

        assertThat(res, instanceOf(List::class.java))
        assertThat(res.size, `is`(4))
    }
}
fun getPlayerListRemote(): List<PlayerDto> {
    return listOf<PlayerDto>(
        PlayerDto(1,"hola",1,1,1,"cm","right",54,3),
        PlayerDto(1,"hola",1,1,1,"cm","right",54,3),
        PlayerDto(1,"hola",1,1,1,"cm","right",54,3),
    )
}
fun getPlayerListLocal(): List<PlayerLocal> {
    return listOf<PlayerLocal>(
        PlayerLocal(1,"hola",1,1,1,"cm","right",54,3),
        PlayerLocal(1,"hola",1,1,1,"cm","right",54,3),
        PlayerLocal(1,"hola",1,1,1,"cm","right",54,3),
        PlayerLocal(1,"hola",1,1,1,"cm","right",54,3),
    )
}