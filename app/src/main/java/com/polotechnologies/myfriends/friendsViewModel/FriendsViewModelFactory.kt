package com.polotechnologies.myfriends.friendsViewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.polotechnologies.myfriends.database.FriendsDatabaseDAO
import java.lang.IllegalArgumentException
import javax.sql.CommonDataSource

class FriendsViewModelFactory(
    private val dataSource: FriendsDatabaseDAO,
    private val application: Application) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FriendsViewModel::class.java)){
            return FriendsViewModel(dataSource,application) as T
        }
        throw IllegalArgumentException("Unknown VIewModel Class")
    }
}