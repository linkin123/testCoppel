package com.tp.testcoppel.data.mappers

import com.tp.testcoppel.core.Mapper
import com.tp.testcoppel.data.local.CharacterLocal
import com.tp.testcoppel.data.model.generic.ResultsItem

class CharacterMapper : Mapper<List<ResultsItem?>?, List<CharacterLocal>> {


    override suspend fun map(input: List<ResultsItem?>?): List<CharacterLocal> {
        return input?.map {
            CharacterLocal( it?.id ?: 0 , it?.name ?: "", "${it?.thumbnail?.path}.${it?.thumbnail?.extension}", it?.description ?: "sin descripcion")
        } ?: listOf()
    }
}