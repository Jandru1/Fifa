package com.example.fifa.data.local.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PlayerTable")
class PlayerLocal(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "club") val club: Int,
    @ColumnInfo(name = "league") val league: Int,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "foot") val foot: String,
    @ColumnInfo(name = "position") val position: String,
    @ColumnInfo(name = "rating") val rating: Int,
)