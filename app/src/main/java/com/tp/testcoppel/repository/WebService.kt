package com.tp.testcoppel.repository


import com.tp.testcoppel.data.model.comics.ComicsResponse
import com.tp.testcoppel.data.model.events.EventsResponse
import com.tp.testcoppel.data.model.generic.CharactersResponse
import com.tp.testcoppel.data.model.series.SeriesResponse
import com.tp.testcoppel.data.model.stories.StoriesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebService{

    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): CharactersResponse

    @GET("/v1/public/characters/{characterId}/comics")
    suspend fun getComicsbyIdCharacter(@Path("characterId") characterId: Int,
                                    @Query("ts") ts: String,
                                    @Query("apikey") apiKey: String,
                                    @Query("hash") hash: String
    ): ComicsResponse

    @GET("/v1/public/characters/{characterId}/events")
    suspend fun getEventsbyIdCharacter(@Path("characterId") characterId: Int,
                                    @Query("ts") ts: String,
                                    @Query("apikey") apiKey: String,
                                    @Query("hash") hash: String
    ): EventsResponse

    @GET("/v1/public/characters/{characterId}/series")
    suspend fun getSeriesbyIdCharacter(@Path("characterId") characterId: Int,
                                    @Query("ts") ts: String,
                                    @Query("apikey") apiKey: String,
                                    @Query("hash") hash: String
    ): SeriesResponse

    @GET("/v1/public/characters/{characterId}/stories")
    suspend fun getStoriesbyIdCharacter(@Path("characterId") characterId: Int,
                                    @Query("ts") ts: String,
                                    @Query("apikey") apiKey: String,
                                    @Query("hash") hash: String
    ): StoriesResponse

}

object RetrofitClient{
    val webService: WebService by lazy {
        ServiceGenerator.RetrofitEncrypt().create(WebService::class.java)

    }
}