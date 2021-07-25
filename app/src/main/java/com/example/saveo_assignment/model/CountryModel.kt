package com.example.saveo_assignment.model

import com.google.gson.annotations.SerializedName

data class CountryModel(

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("timezone")
	val timezone: String? = null,

	@field:SerializedName("name")
	val name: String? = null
)