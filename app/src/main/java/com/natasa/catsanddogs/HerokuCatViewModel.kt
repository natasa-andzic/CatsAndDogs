package com.natasa.catsanddogs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HerokuCatViewModel : ViewModel() {

    val repository = Repository()

    private val _fact = MutableLiveData<String>()
    val fact: LiveData<String> = _fact

    // LiveData to handle errors
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    // Function to fetch users using Retrofit and coroutines
    fun getCatFact() {
        viewModelScope.launch {
            try {
                // Call Retrofit API using coroutine
                val response = repository.getRandomCatFact()
                _fact.postValue(response)  // Post data to LiveData
            } catch (e: Exception) {
                _error.postValue("Error: ${e.message}")  // Handle error
            }
        }
    }
}