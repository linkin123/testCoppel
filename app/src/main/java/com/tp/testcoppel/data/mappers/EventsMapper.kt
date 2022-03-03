package com.tp.testcoppel.data.mappers

import com.tp.testcoppel.core.Mapper
import com.tp.testcoppel.data.local.EventsLocal
import com.tp.testcoppel.data.model.events.ResultsItem

class EventsMapper : Mapper<List<ResultsItem?>?, List<EventsLocal>> {
    override suspend fun map(input: List<ResultsItem?>?): List<EventsLocal> {
        return input?.map {
            EventsLocal(it?.resourceURI ?: "", it?.title ?: "", "${it?.thumbnail?.path}.${it?.thumbnail?.extension}")
        } ?: listOf()

    }


}