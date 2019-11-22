package com.polotechnologies.myfriends.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Friend::class], version = 1, exportSchema = false)
abstract class FriendsDatabase : RoomDatabase() {

    abstract val friendsDatabaseDAO: FriendsDatabaseDAO

    companion object{

        @Volatile
        private var INSTANCE: FriendsDatabase? = null

        fun getInstance(context: Context) : FriendsDatabase{

            synchronized(this){

                var instance = INSTANCE


                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FriendsDatabase::class.java,
                        "friends_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }

    }

}