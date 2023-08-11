package com.example.fifa.di

import android.content.Context
import androidx.room.Room
import com.example.fifa.data.repositories.PlayerRepository
import com.example.fifa.data.repositories.PlayerRepositoryImpl
import com.example.fifa.data.repositories.TeamRepository
import com.example.fifa.data.repositories.TeamRepositoryImpl
import com.example.fifa.data.local.datasources.LocalDataSource
import com.example.fifa.data.local.datasources.LocalDataSourceImpl
import com.example.fifa.data.local.dbs.PlayerDatabase
import com.example.fifa.data.local.dao.PlayerDao
import com.example.fifa.data.local.dao.TeamDao
import com.example.fifa.data.local.dbs.TeamDatabase
import com.example.fifa.data.remote.RemoteDataSource
import com.example.fifa.data.remote.RemoteDataSourceImpl
import com.example.fifa.data.remote.TeamApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val baseUrl = "https://futdb.app/api/"
val dataModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://futdb.app/api/")
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single<Moshi> {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    single<TeamRepository> { TeamRepositoryImpl(get(), get()) }

    single<PlayerRepository> { PlayerRepositoryImpl(get(), get()) }

    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }

    single<LocalDataSource> { LocalDataSourceImpl(get(), get()) }

    single<TeamApi> {
        getTeamApi(get())
    }

    single {
        getTeamDatabase(get())
    }
    single {
        getPlayerDatabase(get())
    }

    single {
        providesTeamDao(get())
    }

    single {
        providesPlayerDao(get())
    }
}

private fun getTeamApi(retrofit: Retrofit) =
    retrofit.create(TeamApi::class.java)

private fun getTeamDatabase(context: Context) : TeamDatabase =
    Room.databaseBuilder(
        context,
        TeamDatabase::class.java, "team-db"
    ).build()

private fun getPlayerDatabase(context: Context) : PlayerDatabase =
    Room.databaseBuilder(
        context,
        PlayerDatabase::class.java, "player-db"
    ).build()

private fun providesTeamDao(db: TeamDatabase) : TeamDao =
    db.teamDao()

private fun providesPlayerDao(db: PlayerDatabase) : PlayerDao =
    db.playerDao()
