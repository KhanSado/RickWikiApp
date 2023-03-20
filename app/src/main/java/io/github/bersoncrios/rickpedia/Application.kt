package io.github.bersoncrios.rickpedia

import android.app.Application
import io.github.bersoncrios.rickpedia.db.RmDatabase
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
        val swService = RetrofitHelper(applicationContext).getInstance().create(RMService::class.java)
        val database = RmDatabase.getDataBase(applicationContext)
        charRepository = CharRepository(swService, database)
    }
}