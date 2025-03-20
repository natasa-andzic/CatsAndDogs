package com.natasa.catsanddogs.api

import com.natasa.catsanddogs.model.DogImage
import retrofit2.http.GET

interface DogImagesService {

    @GET("breeds/image/random")
    suspend fun getDogImage(): DogImage

}