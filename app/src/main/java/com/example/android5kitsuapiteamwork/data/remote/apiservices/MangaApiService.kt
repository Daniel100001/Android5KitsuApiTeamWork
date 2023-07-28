package com.example.android5kitsuapiteamwork.data.remote.apiservices

import com.example.android5kitsuapiteamwork.data.models.AnimeResponse
import com.example.android5kitsuapiteamwork.data.models.MangaModel
import com.example.android5kitsuapiteamwork.data.models.details.MangaDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaApiService {

    @GET("edge/manga")
    suspend fun fetchManga(
        @Query("page[limit]") pageSize: Int,
        @Query("page[offset]") offset: Int
    ): AnimeResponse<MangaModel>

    @GET("edge/manga/{id}")
    suspend fun fetchSingleManga(
        @Path("id") id: String
    ): MangaDetail
}