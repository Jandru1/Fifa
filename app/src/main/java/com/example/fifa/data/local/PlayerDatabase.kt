package com.example.fifa.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fifa.data.local.Model.PlayerLocal

@Database(entities = [PlayerLocal::class], version = 1, exportSchema = false)

abstract class PlayerDatabase : RoomDatabase() {

    abstract fun playerDao(): PlayerDao
}