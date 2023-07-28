package com.example.android5kitsuapiteamwork.ui.fragments.manga

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android5kitsuapiteamwork.R
import com.example.android5kitsuapiteamwork.base.BaseFragment
import com.example.android5kitsuapiteamwork.databinding.FragmentMangaBinding
import com.example.android5kitsuapiteamwork.ui.adapters.MangaAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment : BaseFragment<FragmentMangaBinding, MangaViewModel>(R.layout.fragment_manga) {
    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel: MangaViewModel by viewModels()
    private val mangaAdapter = MangaAdapter()

    override fun initialize() {
        binding.recyclerViewManga.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = mangaAdapter
        }
    }

    override fun setupSubscribes() {
        subscribeToAnime()
    }

    private fun subscribeToAnime() {
        viewModel.fetchManga().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                Log.e("activity", it.toString())
                mangaAdapter.submitData(it)
            }
        }
    }

}