package com.polotechnologies.myfriends.friendsViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.polotechnologies.myfriends.database.Friend
import com.polotechnologies.myfriends.database.FriendsDatabaseDAO
import kotlinx.coroutines.*

class FriendsViewModel(val database: FriendsDatabaseDAO, application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.IO + viewModelJob)

    val _friends = MutableLiveData<LiveData<List<Friend>>>()
    val friends  : LiveData<List<Friend>>?
    get() = _friends.value


    init {
        fetchFriends()
    }

    private fun fetchFriends() {
        _friends.value = database.getAllFriends()
    }

    fun startFriendship(newFriend: Friend) {
        uiScope.launch {
            insertFriend(newFriend)
        }
    }

    private suspend fun insertFriend(friend: Friend) {
        withContext(Dispatchers.IO) {
            database.insertFriend(friend)
        }

    }

    fun updateFriendship(friend: Friend) {
        uiScope.launch {
            updateFriend(friend)
        }
    }

    private suspend fun updateFriend(friend: Friend) {
        withContext(Dispatchers.IO) {
            database.updateFriend(friend)
        }

    }

    fun clearFriendship() {
        uiScope.launch {
            clearFriends()
        }
    }

    private suspend fun clearFriends() {
        withContext(Dispatchers.IO) {
            database.clearFriends()
        }
    }

    fun deleteFriendship(friendId: Long) {
        uiScope.launch {
            deleteFriend(friendId)
        }
    }

    private suspend fun deleteFriend(friendId: Long) {
        withContext(Dispatchers.IO) {
            database.deleteFriend(friendId)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}