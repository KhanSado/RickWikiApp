package io.github.bersoncrios.rickpedia.models


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.SerializedName
import io.github.bersoncrios.rickpedia.R

data class CharTeste(
    @SerializedName("created")
    val created: String,
    @SerializedName("episode")
    val episode: List<String>,
    val name: String,
    @SerializedName("origin")
    val origin: Origin,
    @SerializedName("species")
    val species: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)