package com.example.fifa.data.repositories

import com.example.fifa.data.local.datasources.LocalDataSource
import com.example.fifa.data.mappers.toItemLocal
import com.example.fifa.data.mappers.toItemModel
import com.example.fifa.data.remote.RemoteDataSource
import com.example.fifa.domain.model.TeamModel

class TeamRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    ) : TeamRepository {
    override suspend fun getTeamList(): List<TeamModel> {

        val localData = localDataSource.getTeamList()
        if(localData.isNotEmpty()) {
            return localData.map{
                it.toItemModel()
            }
        } else {
            val remoteData = remoteDataSource.getTeamList()

            localDataSource.insertTeamList(remoteData.map { it.toItemLocal() })

            //QUIERO devolver siempre los datos locales
            val localData = localDataSource.getTeamList()
            return if(localData.isNotEmpty()) {
                localData.map {
                    it.toItemModel()
                }
            } else {
                remoteData.map {
                    it.toItemModel()
                }
            }

        }
        // Lógica de coordinación de datos
    }

/*    override suspend fun getTeamUrl(teamId: Int): PhotoTeamModel {
        return remoteDataSource.getTeamPhoto(teamId).toPhotoTeamModel()
    }*/

}