package com.example.fifa.data

import android.util.Log
import com.example.fifa.data.local.LocalDataSource
import com.example.fifa.data.mappers.toItemLocal
import com.example.fifa.data.mappers.toItemModel
import com.example.fifa.data.mappers.toPhotoTeamModel
import com.example.fifa.data.remote.RemoteDataSource
import com.example.fifa.domain.model.ItemModel
import com.example.fifa.domain.model.PhotoTeamModel

class TeamRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    ) : TeamRepository {
    override suspend fun getTeamList(): List<ItemModel> {

        val localData = localDataSource.getTeamList()
        if(localData.isNotEmpty()) {
            return localData.map{
                it.toItemModel()
            }
        } else {
            //TODO Chekear si localdatasource esta empty, y si no pillar los equipos de la liga española!
            val remoteData = remoteDataSource.getTeamList()

            localDataSource.insertTeamList(remoteData.map { it.toItemLocal() })
            //TODO Coger solo los equipos de la liga Santander!!
            //TODO Coger los urls y meterselos a la database


            //QUIERO devolver siempre los datos locales
            val localData = localDataSource.getTeamList()
            if(localData.isNotEmpty()) {
                return localData.map {
                    it.toItemModel()
                }
            } else {
                Log.d("MAL", "Si entro aqui algo va mal")
                return remoteData.map {
                    it.toItemModel()
                }
            }

        }
        // Lógica de coordinación de datos
    }

    override suspend fun getTeamUrl(teamId: Int): PhotoTeamModel {
        return remoteDataSource.getTeamPhoto(teamId).toPhotoTeamModel()
    }

}