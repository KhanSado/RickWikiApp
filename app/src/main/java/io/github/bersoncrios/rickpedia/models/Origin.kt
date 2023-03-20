package io.github.bersoncrios.rickpedia.models


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "origin")
data class Origin(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)