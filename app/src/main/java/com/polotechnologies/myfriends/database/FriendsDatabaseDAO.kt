package com.polotechnologies.myfriends.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FriendsDatabaseDAO {

    @Insert
    fun insertFriend(friend : Friend)

    @Update
    fun updateFriend(friend: Friend)

    @Query("SELECT * FROM friends_table WHERE friendId = :key ")
    fun getFriend(key : Long) : Friend

    @Query("SELECT * FROM friends_table ORDER BY friendId ASC")
    fun getAllFriends() : LiveData<List<Friend>>

    @Query("DELETE FROM friends_table")
    fun clearFriends()

    @Query("DELETE FROM friends_table WHERE friendId = :key")
    fun deleteFriend(key: Long)

}