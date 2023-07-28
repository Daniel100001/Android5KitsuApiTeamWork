package com.example.android5kitsuapiteamwork.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.android5kitsuapiteamwork.base.BaseRepository
import com.example.android5kitsuapiteamwork.data.remote.apiservices.AnimeApiService
import com.example.android5kitsuapiteamwork.data.repositories.pagingsources.AnimePagingSource
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val service: AnimeApiService) : BaseRepository(){

    fun fetchAnime() = Pager(
        PagingConfig(
            pageSize = 10,
            initialLoadSize = 10
        )
    ) {
        AnimePagingSource(service)
    }.liveData
}