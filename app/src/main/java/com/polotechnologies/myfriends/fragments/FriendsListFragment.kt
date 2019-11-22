package com.polotechnologies.myfriends.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.polotechnologies.myfriends.R
import com.polotechnologies.myfriends.database.FriendsDatabase
import com.polotechnologies.myfriends.databinding.FragmentFriendsListBinding
import com.polotechnologies.myfriends.friendsViewModel.FriendsViewModel
import com.polotechnologies.myfriends.friendsViewModel.FriendsViewModelFactory

/**
 * A simple [Fragment] subclass.
 */
class FriendsListFragment : Fragment() {

    lateinit var mBinding : FragmentFriendsListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_friends_list,container,false)

        val application = requireNotNull(this.activity).application
        val dataSource = FriendsDatabase.getInstance(application).friendsDatabaseDAO

        val viewModelFactory = FriendsViewModelFactory(dataSource, application)

        val friendsViewModel =
            ViewModelProviders.of(
                this,viewModelFactory).get(FriendsViewModel::class.java
            )

        mBinding.friendsViewModel = friendsViewModel
        mBinding.lifecycleOwner = this
        return mBinding.root

    }

}
