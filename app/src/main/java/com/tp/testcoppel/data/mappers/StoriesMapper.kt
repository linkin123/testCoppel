package com.tp.testcoppel.data.mappers

import com.tp.testcoppel.core.Mapper
import com.tp.testcoppel.data.local.StoriesLocal
import com.tp.testcoppel.data.model.stories.ResultsItem
import com.tp.testcoppel.ui.utils.defaultUtils.IMG_DEFAULT


class StoriesMapper : Mapper<List<ResultsItem?>?, List<StoriesLocal>> {
    override suspend fun map(input: List<ResultsItem?>?): List<StoriesLocal> {
        return input?.map {
            StoriesLocal(it?.resourceURI ?: "", it?.title ?: "", IMG_DEFAULT)
        } ?: listOf()

    }

}