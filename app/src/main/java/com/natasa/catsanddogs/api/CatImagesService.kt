package com.natasa.catsanddogs.api

import com.natasa.catsanddogs.model.CatImage
import com.natasa.catsanddogs.model.HerokuCat
import retrofit2.http.GET

interface CatImagesService {

    @GET("images/search")
    suspend fun getCatImage(): List<CatImage>
}