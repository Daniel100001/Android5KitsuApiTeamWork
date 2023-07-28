package com.example.android5kitsuapiteamwork.data.remote.apiservices

import com.example.android5kitsuapiteamwork.data.models.AnimeModel
import com.example.android5kitsuapiteamwork.data.models.AnimeResponse
import com.example.android5kitsuapiteamwork.data.models.details.AnimeDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeApiService {

    @GET("edge/anime")
    suspend fun fetchAnime(
        @Query("page[limit]") pageSize: Int,
        @Query("page[offset]") offset: Int,
    ): AnimeResponse<AnimeModel>

    @GET("edge/anime/{id}")
    suspend fun fetchSingleAnime(
        @Path("id") id: String
    ): AnimeDetail
}