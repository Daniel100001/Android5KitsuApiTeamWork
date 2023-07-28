package com.example.android5kitsuapiteamwork.data.models

import com.example.android5kitsuapiteamwork.data.models.attributes.Attributes
import com.google.gson.annotations.SerializedName

data class MangaModel(

    @SerializedName("id")
    val id: String,

    @SerializedName("attributes")
    val attributes: Attributes
)