package io.github.bersoncrios.rickpedia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.bersoncrios.rickpedia.db.RmDatabase
import io.github.bersoncrios.rickpedia.models.Char
import io.github.bersoncrios.rickpedia.models.CharTeste
import io.github.bersoncrios.rickpedia.models.CharactersList
import io.github.bersoncrios.rickpedia.network.RMService

class CharRepository(
    private val rmService: RMService,
    private val rmDatabase: RmDatabase
) {

    //CharList
    private val _itemsCharList = MutableLiveData<CharactersList>()

    val itemsCharList: LiveData<CharactersList>
        get() = _itemsCharList



    //CharList by DB
    private val _itemsCharListDB = MutableLiveData<List<Char>>()
    val itemsCharListDB: LiveData<List<Char>>
        get() = _itemsCharListDB


    //Char by id
    private val _itemsCharbyId = MutableLiveData<CharTeste>()
    val itemsCharbyId: LiveData<CharTeste>
        get() = _itemsCharbyId


    suspend fun getChars() {
        val resChars = rmService.getChar()
        if (resChars.body() != null) {
            rmDatabase.charDao().addChar(resChars.body()!!.char)
            _itemsCharList.postValue(resChars.body())
        }
    }

    fun getCharsDB() {
        _itemsCharListDB.postValue(rmDatabase.charDao().fetchChar())
    }

    suspend fun getCharsById(id: Int) {
        val resCharById = rmService.getCharById(id)
        if (resCharById.body() != null) {
            _itemsCharbyId.postValue(resCharById.body())
        }
    }
}