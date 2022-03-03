package com.tp.testcoppel.data.mappers

import com.tp.testcoppel.core.Mapper
import com.tp.testcoppel.data.local.SeriesLocal
import com.tp.testcoppel.data.model.series.ResultsItem
import com.tp.testcoppel.ui.utils.defaultUtils.IMG_DEFAULT


class SeriesMapper : Mapper<List<ResultsItem?>?, List<SeriesLocal>> {

    override suspend fun map(input: List<ResultsItem?>?): List<SeriesLocal> {
        return input?.map {
            SeriesLocal(it?.resourceURI ?: "", it?.title ?: "", IMG_DEFAULT)
        } ?: listOf()

    }

}