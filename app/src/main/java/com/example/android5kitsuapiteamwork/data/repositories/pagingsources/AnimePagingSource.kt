package com.example.android5kitsuapiteamwork.data.repositories.pagingsources

import android.net.Uri
import com.example.android5kitsuapiteamwork.base.BasePagingSource
import com.example.android5kitsuapiteamwork.data.models.AnimeModel
import com.example.android5kitsuapiteamwork.data.remote.apiservices.AnimeApiService

private const val CHARACTER_STARTING_PAGE_INDEX = 1

class AnimePagingSource (private var service: AnimeApiService) : BasePagingSource<AnimeModel>() {

    override suspend fun fetchData(params: LoadParams<Int>): LoadResult<Int, AnimeModel> {
        val position = params.key ?: CHARACTER_STARTING_PAGE_INDEX
        val pageSize = params.loadSize
        val response = service.fetchAnime(pageSize, position)
        val next = response.links.next
        val nextPageNumber = Uri.parse(next).getQueryParameter("page[offset]")!!.toInt()
        return LoadResult.Page(
            data = response.data,
            prevKey = null,
            nextKey = nextPageNumber
        )
    }
}