package com.polotechnologies.myfriends.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.polotechnologies.myfriends.R
import com.polotechnologies.myfriends.database.Friend
import com.polotechnologies.myfriends.database.FriendsDatabase
import com.polotechnologies.myfriends.databinding.FragmentNewFriendBinding
import com.polotechnologies.myfriends.friendsViewModel.FriendsViewModel
import com.polotechnologies.myfriends.friendsViewModel.FriendsViewModelFactory

/**
 * A simple [Fragment] subclass.
 */
class NewFriendFragment : Fragment() {

    lateinit var mBinding : FragmentNewFriendBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_new_friend, container, false )

        val application = requireNotNull(this.activity).application
        val dataSource = FriendsDatabase.getInstance(application).friendsDatabaseDAO

        val viewModelFactory = FriendsViewModelFactory(dataSource, application)

        val friendsViewModel =
            ViewModelProviders.of(
                this,viewModelFactory).get(
                FriendsViewModel::class.java
            )

        mBinding.btnSaveFriend.setOnClickListener{
            createFriend(friendsViewModel)
        }
        
        return mBinding.root
    }

    private fun createFriend(friendsViewModel: FriendsViewModel) {

        val friendFirstName = mBinding.etFirstName.text.toString()
        val friendLastName = mBinding.etLastName.text.toString()
        val friendRating = mBinding.rbFriend.rating

        val friend = Friend(
            0L,
            friendFirstName,
            friendLastName,
            friendRating.toInt())

        friendsViewModel.startFriendship(friend)
        findNavController().navigate(R.id.action_newFriendFragment_to_friendsListFragment)
    }


}
