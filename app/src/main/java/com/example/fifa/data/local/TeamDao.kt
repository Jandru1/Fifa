package com.example.fifa.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fifa.data.local.Model.TeamLocal

@Dao
interface TeamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<TeamLocal>)


    //Este id es el de un equipo HERO del fifa que tiene jugadores historicos, y por algun motivo la api lo coloca en la liga española
    @Query("SELECT * FROM TEAMTABLE WHERE league=53 AND id != 114605" )
    suspend fun getAll() : List<TeamLocal>
}