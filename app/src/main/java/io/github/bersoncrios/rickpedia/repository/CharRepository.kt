package io.github.bersoncrios.rickpedia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.bersoncrios.rickpedia.models.CharTeste
import io.github.bersoncrios.rickpedia.models.CharactersList
import io.github.bersoncrios.rickpedia.network.RMService

class CharRepository(
    private val rmService: RMService
) {

    //CharList
    private val _itemsCharList = MutableLiveData<CharactersList>()

    val itemsCharList: LiveData<CharactersList>
        get() = _itemsCharList


    //Char by id
    private val _itemsCharbyId = MutableLiveData<CharTeste>()

    val itemsCharbyId: LiveData<CharTeste>
        get() = _itemsCharbyId


    suspend fun getChars() {
        val resChars = rmService.getChar()
        if (resChars.body() != null) {
            _itemsCharList.postValue(resChars.body())
        }
    }

    suspend fun getCharsById(id: Int) {
        val resCharById = rmService.getCharById(id)
        if (resCharById.body() != null) {
            _itemsCharbyId.postValue(resCharById.body())
        }
    }
}