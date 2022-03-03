package com.tp.testcoppel.data.local

data class ComicsLocal(override val resourceId : String, override val name : String,  override val img : String) : SectionLocal(resourceId, name, img)
