package io.github.bersoncrios.rickpedia.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.bersoncrios.rickpedia.models.CharTeste
import io.github.bersoncrios.rickpedia.models.CharactersList
import io.github.bersoncrios.rickpedia.repository.CharRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharViewModel(
    private val repository: CharRepository
): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getChars()
            repository.getCharsById(21)
        }
    }

    val chars: LiveData<CharactersList>
        get() = repository.itemsCharList


    val charById: LiveData<CharTeste>
        get() = repository.itemsCharbyId
}