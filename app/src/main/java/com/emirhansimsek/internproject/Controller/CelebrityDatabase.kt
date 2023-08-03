package com.emirhansimsek.internproject.Controller

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.emirhansimsek.internproject.Model.Celebrity


@Database(entities = arrayOf(Celebrity.User.Celebrities::class), version = 2)
abstract class CelebrityDatabase : RoomDatabase() {

    abstract fun celebrityDao(): CelebrityDAO
    private var db: CelebrityDatabase? = null

    /*fun createDatabase(context: Context): CelebrityDatabase? {
       val db = Room.databaseBuilder(context.applicationContext,
            CelebrityDatabase::class.java, "celebritydatabase").build()
        return db
    }*/
}