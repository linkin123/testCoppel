package com.tp.testcoppel.repository

import com.tp.testcoppel.data.local.*

interface CharactersRepository {
    suspend fun getCharacters() : List<CharacterLocal>
    suspend fun getEventsByCharacter(id : Int) : List<EventsLocal>
    suspend fun getComicsByCharacter(id : Int) : List<ComicsLocal>
    suspend fun getSeriesByCharacter(id : Int) : List<SeriesLocal>
    suspend fun getStoriesByCharacter(id : Int) : List<StoriesLocal>

}