package com.jitendra.myassignment.model

import com.google.gson.annotations.SerializedName

data class Employee(
    val uuid: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("phone_number") val phoneNumber: String?,
    @SerializedName("email_address") val email: String,
    val biography: String?,
    @SerializedName("photo_url_small") val photoUrlSmall: String?,
    @SerializedName("photo_url_large") val photoUrlLarge: String?,
    val team: String,
    @SerializedName("employee_type") val employeeType: String
)