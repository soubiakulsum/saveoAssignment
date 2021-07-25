package com.example.saveo_assignment.model

import com.google.gson.annotations.SerializedName

data class ScheduleModel(

	@field:SerializedName("days")
	val days: List<String?>? = null,

	@field:SerializedName("time")
	val time: String? = null
)