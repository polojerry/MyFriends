package com.polotechnologies.myfriends.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "friends_table")
data class Friend(

    @PrimaryKey(autoGenerate = true)
    var friendId: Long = 0L,

    @ColumnInfo(name = "firstName")
    var firstName: String = "",

    @ColumnInfo(name= "lastName")
    var lastName: String = "",

    @ColumnInfo(name = "friendsRating")
    var friendsRank: Int= -1
)