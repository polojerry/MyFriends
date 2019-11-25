package com.polotechnologies.myfriends.recyclerView

import android.view.View
import android.widget.RatingBar
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.polotechnologies.myfriends.R

class FriendsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val firstName = itemView.findViewById<AppCompatTextView>(R.id.tv_friend_first_name)
    val lastName = itemView.findViewById<AppCompatTextView>(R.id.tv_friend_last_name)
    val rating = itemView.findViewById<RatingBar>(R.id.ratingBar)
}
