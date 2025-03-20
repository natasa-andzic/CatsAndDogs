package com.natasa.catsanddogs

import com.natasa.catsanddogs.api.CatImagesRetrofitClient
import com.natasa.catsanddogs.api.DogImagesRetrofitClient
import com.natasa.catsanddogs.api.HerokuCatRetrofitClient
import com.natasa.catsanddogs.api.KinduffDogRetrofitClient
import com.natasa.catsanddogs.model.CatImage
import com.natasa.catsanddogs.model.DogImage
import com.natasa.catsanddogs.model.KinduffDog

class Repository {

    suspend fun getRandomCatFact(): String {
        return HerokuCatRetrofitClient.apiService.getCatFacts().random().text
    }

    suspend fun getRandomDogFact(): KinduffDog {
        return KinduffDogRetrofitClient.apiService.getDogFact()
    }

    suspend fun getCatImage(): CatImage {
        return CatImagesRetrofitClient.apiService.getCatImage().first()
    }

    suspend fun getDogImage(): DogImage {
        return DogImagesRetrofitClient.apiService.getDogImage()
    }
}