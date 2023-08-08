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

    @Query("SELECT * FROM TEAMTABLE WHERE league=53" )
    suspend fun getAll() : List<TeamLocal>
}