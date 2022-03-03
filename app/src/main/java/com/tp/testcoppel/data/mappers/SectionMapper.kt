package com.tp.testcoppel.data.mappers

import com.tp.testcoppel.core.Mapper
import com.tp.testcoppel.data.local.SectionLocal
import com.tp.testcoppel.data.model.comics.ResultsItem

class SectionMapper : Mapper<List<ResultsItem?>?, List<SectionLocal>> {
    override suspend fun map(input: List<ResultsItem?>?): List<SectionLocal> {
        return input?.map {
            SectionLocal(it?.resourceURI ?: "", it?.title ?: "", "${it?.thumbnail?.path}.${it?.thumbnail?.extension}")
        } ?: listOf()
    }
}