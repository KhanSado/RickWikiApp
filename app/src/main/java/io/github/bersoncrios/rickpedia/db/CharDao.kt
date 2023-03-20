package io.github.bersoncrios.rickpedia.db

import androidx.room.*

@Dao
interface CharDao {
    @Insert
    fun addChar(char: List<io.github.bersoncrios.rickpedia.models.Char>)

    @Query("SELECT * FROM char")
    fun fetchChar(): List<io.github.bersoncrios.rickpedia.models.Char>

    @Update
    fun updateChar(char: io.github.bersoncrios.rickpedia.models.Char)

    @Delete
    fun deleteChar(char: io.github.bersoncrios.rickpedia.models.Char)

}