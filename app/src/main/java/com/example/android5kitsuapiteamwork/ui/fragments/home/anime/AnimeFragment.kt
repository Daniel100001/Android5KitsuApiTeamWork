package com.example.android5kitsuapiteamwork.ui.fragments.home.anime

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android5kitsuapiteamwork.R
import com.example.android5kitsuapiteamwork.base.BaseFragment
import com.example.android5kitsuapiteamwork.databinding.FragmentAnimeBinding

class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {
    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()

}