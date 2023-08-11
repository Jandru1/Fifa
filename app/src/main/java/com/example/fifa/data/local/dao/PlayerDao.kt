package com.example.fifa.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fifa.data.local.Model.PlayerLocal

@Dao
interface PlayerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<PlayerLocal>)

    @Query("SELECT * FROM PLAYERTABLE WHERE club=:idTeam" )
    suspend fun getAll(idTeam: Int) : List<PlayerLocal>

    @Query("SELECT * FROM PLAYERTABLE WHERE ID=:playerId")
    suspend fun getPlayerDetail(playerId: Int) : PlayerLocal
}