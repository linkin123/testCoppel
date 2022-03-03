package com.tp.testcoppel.repository

import com.tp.testcoppel.data.local.*
import com.tp.testcoppel.data.mappers.*
import com.tp.testcoppel.data.remote.RemoteCharacterDataSource

class CharacterRepositoryImpl(private val dataSource : RemoteCharacterDataSource) : CharactersRepository{
    override suspend fun getCharacters(): List<CharacterLocal> {
        return CharacterMapper().map(dataSource.getCharacters().data?.results )
    }

    override suspend fun getEventsByCharacter(id : Int): List<EventsLocal> {
        return EventsMapper().map(dataSource.getEventsbyId(id).data?.results)
    }

    override suspend fun getComicsByCharacter(id : Int): List<ComicsLocal> {
        return ComicsMapper().map(dataSource.getComicsbyId(id).data?.results)
    }

    override suspend fun getSeriesByCharacter(id : Int): List<SeriesLocal> {
        return SeriesMapper().map(dataSource.getSeriesbyId(id).data?.results)
    }

    override suspend fun getStoriesByCharacter(id : Int): List<StoriesLocal> {
        return StoriesMapper().map(dataSource.getStoriesbyId(id).data?.results)
    }

}