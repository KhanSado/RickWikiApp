package io.github.bersoncrios.rickpedia

import android.app.Application
import io.github.bersoncrios.rickpedia.network.RMService
import io.github.bersoncrios.rickpedia.network.RetrofitHelper
import io.github.bersoncrios.rickpedia.repository.CharRepository

class Application : Application() {

    lateinit var charRepository: CharRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val swService = RetrofitHelper.getInstance().create(RMService::class.java)
        charRepository = CharRepository(swService)
    }
}