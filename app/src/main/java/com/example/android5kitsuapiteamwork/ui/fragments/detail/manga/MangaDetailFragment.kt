package com.example.android5kitsuapiteamwork.ui.fragments.detail.manga

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.android5kitsuapiteamwork.R
import com.example.android5kitsuapiteamwork.base.BaseFragment
import com.example.android5kitsuapiteamwork.databinding.FragmentMangaDetailBinding
import com.example.android5kitsuapiteamwork.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaDetailFragment :
    BaseFragment<FragmentMangaDetailBinding, MangaDetailViewModel>(R.layout.fragment_manga_detail) {

    override val binding by viewBinding(FragmentMangaDetailBinding::bind)
    override val viewModel: MangaDetailViewModel by viewModels()
    private val args by navArgs<MangaDetailFragmentArgs>()

    override fun setupSubscribes() {
        subscribeToAnime()
    }

    private fun subscribeToAnime() {
        viewModel.fetchMangaById(args.id).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                    Toast.makeText(requireContext(), "loading", Toast.LENGTH_SHORT).show()
                }
                is Resource.Success -> {
                    Glide.with(binding.imageViewPoster)
                        .load(it.data?.animeModel?.attributes?.posterImage?.original)
                        .into(binding.imageViewPoster)
                    binding.textViewDetail.text = it.data?.animeModel?.attributes?.title?.nameInEnglish
                    binding.textView.text = it.data?.animeModel?.attributes?.description
                }
            }
        }
    }
}