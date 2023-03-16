package io.github.bersoncrios.rickpedia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.bersoncrios.rickpedia.models.CharactersList
import io.github.bersoncrios.rickpedia.network.RMService

class CharRepository(
    private val rmService: RMService
) {
    private val _items = MutableLiveData<CharactersList>()

    val items: LiveData<CharactersList>
        get() = _items

    suspend fun getChars() {
        val res = rmService.getChar()
        if (res.body() != null) {
            _items.postValue(res.body())
        }
    }
}