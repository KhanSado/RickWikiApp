package io.github.bersoncrios.rickpedia

import androidx.room.TypeConverter
import io.github.bersoncrios.rickpedia.models.Location
import io.github.bersoncrios.rickpedia.models.Origin
import org.json.JSONObject

class TypeConverter {
    @TypeConverter
    fun fromLocation(source: Location): String {
        return JSONObject().apply {
            put("name", source.name)
            put("url", source.url)
        }.toString()
    }

    @TypeConverter
    fun toLocation(source: String): Location {
        val json = JSONObject(source)
        return Location(json.getString("name"), json.getString("url"))
    }

    @TypeConverter
    fun fromOrigin(source: Origin): String {
        return JSONObject().apply {
            put("name", source.name)
            put("url", source.url)
        }.toString()
    }

    @TypeConverter
    fun toOrigin(source: String): Origin {
        val json = JSONObject(source)
        return Origin(json.getString("name"), json.getString("url"))
    }
}