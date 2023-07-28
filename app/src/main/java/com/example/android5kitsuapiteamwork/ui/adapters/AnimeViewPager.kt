package com.example.android5kitsuapiteamwork.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android5kitsuapiteamwork.ui.fragments.anime.AnimeFragment
import com.example.android5kitsuapiteamwork.ui.fragments.manga.MangaFragment

class AnimeViewPager(fragment: Fragment) : FragmentStateAdapter(fragment) {
    companion object {
        private const val NUM_TABS = 2
    }

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AnimeFragment()
            1 -> MangaFragment()
            else -> throw IllegalArgumentException("lox: $position")
        }
    }
}