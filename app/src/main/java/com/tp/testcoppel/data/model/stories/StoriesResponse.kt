package com.tp.testcoppel.data.model.stories

import com.google.gson.annotations.SerializedName

data class StoriesResponse(

	@field:SerializedName("copyright")
	val copyright: String? = null,

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("attributionHTML")
	val attributionHTML: String? = null,

	@field:SerializedName("attributionText")
	val attributionText: String? = null,

	@field:SerializedName("etag")
	val etag: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class OriginalIssue(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("resourceURI")
	val resourceURI: String? = null
)

data class Characters(

	@field:SerializedName("collectionURI")
	val collectionURI: String? = null,

	@field:SerializedName("available")
	val available: Int? = null,

	@field:SerializedName("returned")
	val returned: Int? = null,

	@field:SerializedName("items")
	val items: List<ItemsItem?>? = null
)

data class ItemsItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("resourceURI")
	val resourceURI: String? = null,

	@field:SerializedName("role")
	val role: String? = null
)

data class Series(

	@field:SerializedName("collectionURI")
	val collectionURI: String? = null,

	@field:SerializedName("available")
	val available: Int? = null,

	@field:SerializedName("returned")
	val returned: Int? = null,

	@field:SerializedName("items")
	val items: List<ItemsItem?>? = null
)

data class Comics(

	@field:SerializedName("collectionURI")
	val collectionURI: String? = null,

	@field:SerializedName("available")
	val available: Int? = null,

	@field:SerializedName("returned")
	val returned: Int? = null,

	@field:SerializedName("items")
	val items: List<ItemsItem?>? = null
)

data class Creators(

	@field:SerializedName("collectionURI")
	val collectionURI: String? = null,

	@field:SerializedName("available")
	val available: Int? = null,

	@field:SerializedName("returned")
	val returned: Int? = null,

	@field:SerializedName("items")
	val items: List<Any?>? = null
)

data class Events(

	@field:SerializedName("collectionURI")
	val collectionURI: String? = null,

	@field:SerializedName("available")
	val available: Int? = null,

	@field:SerializedName("returned")
	val returned: Int? = null,

	@field:SerializedName("items")
	val items: List<Any?>? = null
)

data class Data(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("offset")
	val offset: Int? = null,

	@field:SerializedName("limit")
	val limit: Int? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null
)

data class ResultsItem(

	@field:SerializedName("thumbnail")
	val thumbnail: Any? = null,

	@field:SerializedName("creators")
	val creators: Creators? = null,

	@field:SerializedName("comics")
	val comics: Comics? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("resourceURI")
	val resourceURI: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("characters")
	val characters: Characters? = null,

	@field:SerializedName("originalIssue")
	val originalIssue: OriginalIssue? = null,

	@field:SerializedName("series")
	val series: Series? = null,

	@field:SerializedName("modified")
	val modified: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("events")
	val events: Events? = null
)
