package io.github.bersoncrios.rickpedia.models


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "location")
data class Location(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)