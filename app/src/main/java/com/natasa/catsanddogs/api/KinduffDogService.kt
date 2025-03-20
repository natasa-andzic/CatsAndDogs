package com.natasa.catsanddogs.api

import com.natasa.catsanddogs.model.KinduffDog
import retrofit2.http.GET

interface KinduffDogService {

    // Define an API call to fetch a list of users (GET request)
    @GET("/api/facts")
    suspend fun getDogFact(): KinduffDog

}