package com.polotechnologies.myfriends.friendsViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.polotechnologies.myfriends.database.FriendsDatabaseDAO

class FriendsViewModel(
    val database: FriendsDatabaseDAO,
    application: Application): AndroidViewModel(application)