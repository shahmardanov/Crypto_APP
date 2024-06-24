package com.example.mini_application.data.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("code")
    val code: String?,
    @SerializedName("FullName")
    val fullName: String?,
    @SerializedName("ShortName")
    val shortName: String?
)