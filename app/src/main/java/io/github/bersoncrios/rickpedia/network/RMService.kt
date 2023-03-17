package io.github.bersoncrios.rickpedia.network

import io.github.bersoncrios.rickpedia.models.CharTeste
import io.github.bersoncrios.rickpedia.models.CharactersList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RMService {

    @GET("character")
    suspend fun getChar() : Response<CharactersList>

    @GET("character/{id}")
    suspend fun getCharById(
        @Path("id") id: Int
    ) : Response<CharTeste>

}