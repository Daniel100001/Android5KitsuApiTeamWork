package com.example.android5kitsuapiteamwork.data.models.attributes

import com.google.gson.annotations.SerializedName

data class Titles(

    @SerializedName("ja_jp")
    val nameInJapanese: String,

    @SerializedName("en_jp")
    val nameInEnglish: String
)