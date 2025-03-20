package com.natasa.catsanddogs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class KinduffDogViewModel: ViewModel() {

    val repository = Repository()

    private val _fact = MutableLiveData<String>()
    val fact: LiveData<String> = _fact

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getDogFact() {
        viewModelScope.launch {
            try {
                val response = repository.getRandomDogFact()
                _fact.postValue(response.facts[0])  // Post data to LiveData
            } catch (e: Exception) {
                _error.postValue("Error: ${e.message}")  // Handle error
            }
        }
    }
}