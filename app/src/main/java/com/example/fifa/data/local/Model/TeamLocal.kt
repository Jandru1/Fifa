package com.example.fifa.data.local.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TeamTable")
data class TeamLocal(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "league") val league: Int,
   // @ColumnInfo(name = "favorite") val favorite: Boolean
)
