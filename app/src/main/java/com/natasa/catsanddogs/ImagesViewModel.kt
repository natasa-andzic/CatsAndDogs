package com.natasa.catsanddogs

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ImagesViewModel: ViewModel() {

    val repository = Repository()

    private val _image = MutableLiveData<String>()
    val image: LiveData<String> = _image

    private val _dogImage = MutableLiveData<String>()
    val dogImage: LiveData<String> = _dogImage

    // LiveData to handle errors
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    // Function to fetch users using Retrofit and coroutines
    fun getCatImage() {
        viewModelScope.launch {
            try {
                // Call Retrofit API using coroutine
                val response = repository.getCatImage()
                _image.postValue(response.url)  // Post data to LiveData
            } catch (e: Exception) {
                _error.postValue("Error: ${e.message}")  // Handle error
            }
        }
    }

    fun getDogImage() {
        viewModelScope.launch {
            try {
                // Call Retrofit API using coroutine
                val response = repository.getDogImage().message
                Log.d("Natasa response", response)
                _dogImage.postValue(response)  // Post data to LiveData
            } catch (e: Exception) {
                _error.postValue("Error: ${e.message}")  // Handle error
            }
        }
    }
}