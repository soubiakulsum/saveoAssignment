package com.example.saveo_assignment.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RatingModel(

	@field:SerializedName("average")
	val average: Any? = null
): Serializable