package com.example.saveo_assignment.model

import com.google.gson.annotations.SerializedName

data class ImageModel(

	@field:SerializedName("original")
	val original: String? = null,

	@field:SerializedName("medium")
	val medium: String? = null
)