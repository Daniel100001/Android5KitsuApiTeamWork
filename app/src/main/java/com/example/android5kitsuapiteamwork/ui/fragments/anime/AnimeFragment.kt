package com.example.android5kitsuapiteamwork.ui.fragments.anime

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android5kitsuapiteamwork.R
import com.example.android5kitsuapiteamwork.base.BaseFragment
import com.example.android5kitsuapiteamwork.databinding.FragmentAnimeBinding
import com.example.android5kitsuapiteamwork.ui.adapters.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {
    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel by viewModels<AnimeViewModel>()
    private val animeAdapter = AnimeAdapter()

    override fun initialize() {
        binding.animeRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = animeAdapter
        }
    }

    override fun setupSubscribes() {
        subscribeToAnime()
    }

    private fun subscribeToAnime() {
        lifecycleScope.launch {
            viewModel.fetchAnime().observe(viewLifecycleOwner) {
                lifecycleScope.launch {
                    animeAdapter.submitData(it)
                    Log.e("activity", it.toString())
                }
            }
        }
    }
}
