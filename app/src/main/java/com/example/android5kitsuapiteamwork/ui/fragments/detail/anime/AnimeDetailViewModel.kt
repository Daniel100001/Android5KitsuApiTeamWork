package com.example.android5kitsuapiteamwork.ui.fragments.detail.anime

import androidx.lifecycle.ViewModel
import com.example.android5kitsuapiteamwork.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(private val repository: AnimeRepository) :
    ViewModel() {

    fun fetchIdAnime(id: String) = repository.fetchSingleAnime(id)
}