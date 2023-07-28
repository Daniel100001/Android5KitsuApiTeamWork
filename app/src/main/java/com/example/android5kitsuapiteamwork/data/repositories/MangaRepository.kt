package com.example.android5kitsuapiteamwork.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.android5kitsuapiteamwork.base.BaseRepository
import com.example.android5kitsuapiteamwork.data.remote.apiservices.MangaApiService
import com.example.android5kitsuapiteamwork.data.repositories.pagingsources.MangaPagerSource
import javax.inject.Inject

class MangaRepository @Inject constructor(private val service: MangaApiService) : BaseRepository() {

    fun fetchManga() = Pager(
        PagingConfig(
            pageSize = 10,
            initialLoadSize = 10
        )
    ) {
        MangaPagerSource(service)
    }.liveData
}