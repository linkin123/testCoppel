package com.tp.testcoppel.data.model.comics

import com.google.gson.annotations.SerializedName

data class ComicsResponse(

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

data class ImagesItem(

	@field:SerializedName("path")
	val path: String? = null,

	@field:SerializedName("extension")
	val extension: String? = null
)

data class Stories(

	@field:SerializedName("collectionURI")
	val collectionURI: String? = null,

	@field:SerializedName("available")
	val available: Int? = null,

	@field:SerializedName("returned")
	val returned: Int? = null,

	@field:SerializedName("items")
	val items: List<ItemsItem?>? = null
)

data class DatesItem(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)

data class VariantsItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("resourceURI")
	val resourceURI: String? = null
)

data class Creators(

	@field:SerializedName("collectionURI")
	val collectionURI: String? = null,

	@field:SerializedName("available")
	val available: Int? = null,

	@field:SerializedName("returned")
	val returned: Int? = null,

	@field:SerializedName("items")
	val items: List<ItemsItem?>? = null
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

data class Events(

	@field:SerializedName("collectionURI")
	val collectionURI: String? = null,

	@field:SerializedName("available")
	val available: Int? = null,

	@field:SerializedName("returned")
	val returned: Int? = null,

	@field:SerializedName("items")
	val items: List<ItemsItem?>? = null
)

data class TextObjectsItem(

	@field:SerializedName("language")
	val language: String? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("type")
	val type: String? = null
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

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("resourceURI")
	val resourceURI: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)

data class Series(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("resourceURI")
	val resourceURI: String? = null
)

data class UrlsItem(

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class PricesItem(

	@field:SerializedName("price")
	val price: Double? = null,

	@field:SerializedName("type")
	val type: String? = null
)

data class Thumbnail(

	@field:SerializedName("path")
	val path: String? = null,

	@field:SerializedName("extension")
	val extension: String? = null
)

data class ResultsItem(

	@field:SerializedName("creators")
	val creators: Creators? = null,

	@field:SerializedName("issueNumber")
	val issueNumber: Int? = null,

	@field:SerializedName("isbn")
	val isbn: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("variants")
	val variants: List<Any?>? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("diamondCode")
	val diamondCode: String? = null,

	@field:SerializedName("characters")
	val characters: Characters? = null,

	@field:SerializedName("urls")
	val urls: List<UrlsItem?>? = null,

	@field:SerializedName("ean")
	val ean: String? = null,

	@field:SerializedName("collections")
	val collections: List<Any?>? = null,

	@field:SerializedName("modified")
	val modified: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("prices")
	val prices: List<PricesItem?>? = null,

	@field:SerializedName("events")
	val events: Events? = null,

	@field:SerializedName("collectedIssues")
	val collectedIssues: List<Any?>? = null,

	@field:SerializedName("pageCount")
	val pageCount: Int? = null,

	@field:SerializedName("thumbnail")
	val thumbnail: Thumbnail? = null,

	@field:SerializedName("images")
	val images: List<ImagesItem?>? = null,

	@field:SerializedName("stories")
	val stories: Stories? = null,

	@field:SerializedName("textObjects")
	val textObjects: List<TextObjectsItem?>? = null,

	@field:SerializedName("digitalId")
	val digitalId: Int? = null,

	@field:SerializedName("format")
	val format: String? = null,

	@field:SerializedName("upc")
	val upc: String? = null,

	@field:SerializedName("dates")
	val dates: List<DatesItem?>? = null,

	@field:SerializedName("resourceURI")
	val resourceURI: String? = null,

	@field:SerializedName("variantDescription")
	val variantDescription: String? = null,

	@field:SerializedName("issn")
	val issn: String? = null,

	@field:SerializedName("series")
	val series: Series? = null
)
