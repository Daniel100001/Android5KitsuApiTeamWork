package com.example.android5kitsuapiteamwork.data.models

import com.google.gson.annotations.SerializedName

data class SingInModel(

    @SerializedName("access_token")
    val access_token : String? = null,
    @SerializedName("created_at")
    val created_at: Int? = null,
    @SerializedName("expires_in")
    val expires_in: Int? = null,
    @SerializedName("refresh_token")
    val refresh_token: String? = null,
    @SerializedName("token_type")
    val token_type: String? = null
)