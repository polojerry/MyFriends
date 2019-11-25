package com.polotechnologies.myfriends.friendsViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.polotechnologies.myfriends.database.Friend
import com.polotechnologies.myfriends.database.FriendsDatabaseDAO
import kotlinx.coroutines.*

class FriendsViewModel(
    val database: FriendsDatabaseDAO,
    application: Application): AndroidViewModel(application){

    private var viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val friends = database.getAllFriends()


    fun startFriendship(newFriend: Friend){
        uiScope.launch {
            insertFriend(newFriend)
        }
    }

    private suspend fun insertFriend(friend : Friend){
        withContext(Dispatchers.IO){
            database.insertFriend(friend)
        }

    }

    fun updateFriendship(friend: Friend){
        uiScope.launch {
            updateFriend(friend)
        }
    }

    private suspend fun updateFriend(friend : Friend){
        withContext(Dispatchers.IO){
            database.updateFriend(friend)
        }

    }

    fun clearFriendship(){
        uiScope.launch {
            clearFriends()
        }
    }

    private suspend fun clearFriends() {
        withContext(Dispatchers.IO){
            database.clearFriends()
        }
    }

    fun deleteFriendship(friendId : Long){
        uiScope.launch {
            deleteFriend(friendId)
        }
    }

    private suspend fun deleteFriend(friendId: Long) {
        withContext(Dispatchers.IO){
            database.deleteFriend(friendId)
        }
    }
}