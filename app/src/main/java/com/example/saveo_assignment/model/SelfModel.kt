package com.example.saveo_assignment.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SelfModel(

	@field:SerializedName("href")
	val href: String? = null
): Serializable