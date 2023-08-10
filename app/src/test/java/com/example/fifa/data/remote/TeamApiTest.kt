package com.example.fifa.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.fifa.di.baseUrl
import com.example.fifa.testutils.DefaultDispatcherRule
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class TeamApiTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = DefaultDispatcherRule()


    private lateinit var api: TeamApi

    @Before
    fun setup() {
        api = retrofit.create(TeamApi::class.java)
    }

    companion object {
        private lateinit var retrofit: Retrofit

        @BeforeClass
        @JvmStatic
        fun setupCommon() {
            retrofit = Retrofit.Builder()
                // lo ideal es probar contra un entorno estable
                // entorno de QA
                .baseUrl(baseUrl)
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(
                            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
                                .apply {
                                    level = HttpLoggingInterceptor.Level.BODY
                                }).build()
                )
                .addConverterFactory(
                    MoshiConverterFactory.create(
                        Moshi.Builder()
                            .addLast(KotlinJsonAdapterFactory())
                            .build()
                    )
                ).build()
        }
    }

    @Test
    fun `WHEN request player list EXPECT result`() = runTest {
        val result = api.getPlayersList(1)
        MatcherAssert.assertThat(result.players.isNotEmpty(), CoreMatchers.`is`(true))
    }
    @Test
    fun `WHEN request team list EXPECT result`() = runTest {
        val result = api.getTeamList(1)
        MatcherAssert.assertThat(result.items.isEmpty(), CoreMatchers.`is`(false))
    }
}