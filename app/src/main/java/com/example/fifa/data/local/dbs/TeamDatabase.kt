package com.example.fifa.data.local.dbs

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fifa.data.local.Model.TeamLocal
import com.example.fifa.data.local.dao.TeamDao

@Database(entities = [TeamLocal::class], version = 1, exportSchema = false)
//Database(entities = [SuperHeroLocal::class, AnotherLocal::class], version = 1)
abstract class TeamDatabase : RoomDatabase() {
    // List of Dao
    abstract fun teamDao(): TeamDao
}