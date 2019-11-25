package com.polotechnologies.myfriends.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.polotechnologies.myfriends.R
import com.polotechnologies.myfriends.database.Friend

class FriendsRecyclerAdapter : RecyclerView.Adapter<FriendsViewHolder>() {

    var friendsData = listOf<Friend>()

    set(value){
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_friend, parent, false)

        return FriendsViewHolder(view)
    }

    override fun getItemCount() = friendsData.size

    override fun onBindViewHolder(holder: FriendsViewHolder, position: Int) {
       val friend = friendsData[position]

        holder.firstName.text = friend.firstName
        holder.lastName.text = friend.lastName
        holder.rating.rating = friend.friendsRank.toFloat()

    }
}