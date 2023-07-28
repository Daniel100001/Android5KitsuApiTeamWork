package com.example.android5kitsuapiteamwork.data.models

import com.google.gson.annotations.SerializedName

data class SingInRequest(
    @SerializedName("grant_type")
    val grant_type: String,
    @SerializedName("username")
    val email: String,
    @SerializedName("password")
    val password: String,
)