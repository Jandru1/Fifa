package com.example.fifa.data.repositories

import com.example.fifa.data.local.datasources.LocalDataSource
import com.example.fifa.data.mappers.toPlayerLocal
import com.example.fifa.data.mappers.toPlayerModel
import com.example.fifa.data.remote.RemoteDataSource
import com.example.fifa.domain.model.PlayerModel

class PlayerRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : PlayerRepository {
    override suspend fun getPlayersList(idTeam: Int): List<PlayerModel> {

        val localData = localDataSource.getPlayerList(idTeam)
        if(localData.isNotEmpty()) {
            return localData.map{
                it.toPlayerModel()
            }
        }

        else {
            val remoteData = remoteDataSource.getPlayersList()

            localDataSource.insertPlayersList(remoteData.map {
                it.toPlayerLocal()
                }
            )

            var localData = localDataSource.getPlayerList(idTeam)
            if(localData.isNotEmpty()) {
                return localData.map {
                    it.toPlayerModel()
                }
            } else {
                return remoteData.map {
                    it.toPlayerModel()
                }
            }
/*            return remoteData.map {
                it.toPlayerModel()
            }*/
        }
    }

    override suspend fun getPlayerDetail(playerId: Int): PlayerModel {
        return localDataSource.getPlayerDetail(playerId).toPlayerModel()
    }
}