package io.github.bersoncrios.rickpedia.network

import io.github.bersoncrios.rickpedia.models.CharactersList
import retrofit2.Response
import retrofit2.http.GET

interface RMService {

    @GET("character")
    suspend fun getChar() : Response<CharactersList>

}