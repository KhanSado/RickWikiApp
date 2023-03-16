package io.github.bersoncrios.rickpedia.models


import com.google.gson.annotations.SerializedName

data class CharactersList(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val char: List<Char>
)