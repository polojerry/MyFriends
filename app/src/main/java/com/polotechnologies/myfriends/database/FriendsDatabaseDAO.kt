package com.polotechnologies.myfriends.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface FriendsDatabaseDAO {

    @Insert
    fun insertFriend(friend : Friend)

    @Update
    fun updateFriend(friend: Friend)

    @Query("SELECT * FROM friends_table WHERE friendId = :key ")
    fun getFriend(key : Long) : Friend

    @Query("SELECT * FROM friends_table ORDER BY friendId DESC")
    fun getAllFriends() : LiveData<List<Friend>>

    @Query("SELECT * FROM friends_table ORDER BY friendId LIMIT 1")
    fun getLatestFriend() : Friend?

}