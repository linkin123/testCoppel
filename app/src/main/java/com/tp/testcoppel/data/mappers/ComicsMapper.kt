package com.tp.testcoppel.data.mappers

import com.tp.testcoppel.core.Mapper
import com.tp.testcoppel.data.local.ComicsLocal
import com.tp.testcoppel.data.local.SectionLocal
import com.tp.testcoppel.data.model.comics.ResultsItem

class ComicsMapper : Mapper<List<ResultsItem?>?, List<ComicsLocal>> {
    override suspend fun map(input: List<ResultsItem?>?): List<ComicsLocal> {
        return input?.map {
            ComicsLocal(it?.resourceURI ?: "", it?.title ?: "", "${it?.thumbnail?.path}.${it?.thumbnail?.extension}")
        } ?: listOf()
    }
}