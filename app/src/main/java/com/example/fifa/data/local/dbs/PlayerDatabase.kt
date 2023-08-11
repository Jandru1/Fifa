package com.example.fifa.data.local.dbs

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fifa.data.local.Model.PlayerLocal
import com.example.fifa.data.local.dao.PlayerDao

@Database(entities = [PlayerLocal::class], version = 1, exportSchema = false)

abstract class PlayerDatabase : RoomDatabase() {

    abstract fun playerDao(): PlayerDao
}