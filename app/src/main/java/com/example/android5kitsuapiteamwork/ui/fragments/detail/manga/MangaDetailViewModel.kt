package com.example.android5kitsuapiteamwork.ui.fragments.detail.manga

import androidx.lifecycle.ViewModel
import com.example.android5kitsuapiteamwork.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaDetailViewModel @Inject constructor(private val repository: MangaRepository) :
    ViewModel() {

    fun fetchMangaById(id: String) = repository.fetchSingleManga(id)
}