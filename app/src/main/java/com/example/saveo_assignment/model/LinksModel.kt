package com.example.saveo_assignment.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LinksModel(

	@field:SerializedName("self")
	val self: SelfModel? = null,

	@field:SerializedName("previousepisode")
	val previousepisode: PreviousepisodeModel? = null
): Serializable