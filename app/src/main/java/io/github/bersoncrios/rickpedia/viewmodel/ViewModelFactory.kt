package io.github.bersoncrios.rickpedia.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.bersoncrios.rickpedia.repository.CharRepository

class ViewModelFactory(private val repository: CharRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CharViewModel(repository) as T
    }
}