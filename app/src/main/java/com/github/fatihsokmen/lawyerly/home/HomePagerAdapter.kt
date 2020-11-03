package com.github.fatihsokmen.lawyerly.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.github.fatihsokmen.lawyerly.R
import com.github.fatihsokmen.lawyerly.lawyers.ALL
import com.github.fatihsokmen.lawyerly.lawyers.FAVOURITES
import com.github.fatihsokmen.lawyerly.lawyers.FEATURED
import com.github.fatihsokmen.lawyerly.lawyers.LawyerListFragment
import java.lang.IllegalArgumentException

class HomePagerAdapter(private val parent: Fragment) : FragmentStateAdapter(parent) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment =
        LawyerListFragment.newInstance(
            when (position) {
                0 -> FEATURED
                1 -> ALL
                2 -> FAVOURITES
                else -> throw IllegalArgumentException("Invalid id")
            }
        )

    fun getTitleAt(position: Int): CharSequence? =
        parent.resources.getStringArray(R.array.title_lawyers_tab)[position]
}