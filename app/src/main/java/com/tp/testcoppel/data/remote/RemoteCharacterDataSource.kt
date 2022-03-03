package com.tp.testcoppel.data.remote

import com.tp.testcoppel.application.AppConstants
import com.tp.testcoppel.repository.WebService
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class RemoteCharacterDataSource(private val webService: WebService) {

    companion object {
        val ts = Timestamp(System.currentTimeMillis()).time.toString()
    }

    private fun getHash(): String {
        val input = "$ts${AppConstants.PRI_KEY}${AppConstants.PUB_KEY}"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }

    suspend fun getCharacters() = webService.getCharacters(ts, AppConstants.PUB_KEY, getHash())

    suspend fun getComicsbyId(id : Int) = webService.getComicsbyIdCharacter(id ,
        ts, AppConstants.PUB_KEY, getHash())

    suspend fun getEventsbyId(id : Int) = webService.getEventsbyIdCharacter(id ,
        ts, AppConstants.PUB_KEY, getHash())

    suspend fun getSeriesbyId(id : Int) = webService.getSeriesbyIdCharacter(id ,
        ts, AppConstants.PUB_KEY, getHash())

    suspend fun getStoriesbyId(id : Int) = webService.getStoriesbyIdCharacter(id ,
        ts, AppConstants.PUB_KEY, getHash())

}