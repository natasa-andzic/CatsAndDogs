package com.natasa.catsanddogs.api

import com.natasa.catsanddogs.model.HerokuCat
import retrofit2.http.GET

interface HerokuCatService {

    @GET("facts")
    suspend fun getCatFacts(): List<HerokuCat>
}
