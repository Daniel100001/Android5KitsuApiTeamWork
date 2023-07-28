package com.example.android5kitsuapiteamwork.data.models.details

import com.example.android5kitsuapiteamwork.data.models.AnimeModel
import com.google.gson.annotations.SerializedName

data class AnimeDetail(

    @SerializedName("data")
    val animeModel: AnimeModel
)
