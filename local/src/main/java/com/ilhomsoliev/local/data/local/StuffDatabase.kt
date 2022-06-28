package com.ilhomsoliev.local.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ilhomsoliev.local.domain.model.Stuff

@Database(entities = [Stuff::class], version = 1)
abstract class StuffDatabase:RoomDatabase() {
    abstract val stuffDao: StuffDao

    companion object{
        const val DATABASE_NAME = "stuffs_db"
    }
}

