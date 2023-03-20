package io.github.bersoncrios.rickpedia.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.github.bersoncrios.rickpedia.TypeConverter


@Database(entities = [io.github.bersoncrios.rickpedia.models.Char::class], version = 1)
@TypeConverters(TypeConverter::class)
abstract class RmDatabase : RoomDatabase() {

    abstract fun charDao(): CharDao

    companion object {
        @Volatile
        private var INSTANCE : RmDatabase? = null

        fun getDataBase(context: Context) : RmDatabase {

            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        RmDatabase::class.java,
                        "RmDB"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}