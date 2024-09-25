package com.example.kotlinsearchengine

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Document::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun documentDao(): DocumentDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()

                //Set singleton instance
                INSTANCE = instance
                //Return the database instance
                instance
            }
        }
    }

}