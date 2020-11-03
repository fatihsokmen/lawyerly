package com.github.fatihsokmen.lawyerly.lawyers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.fatihsokmen.lawyerly.databinding.FragmentLawyersOverviewBinding
import com.github.fatihsokmen.lawyerly.home.HomePagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class LawyersOverviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLawyersOverviewBinding.inflate(inflater, container, false)
        setupViewPager(binding)
        return binding.root
    }


    private fun setupViewPager(binding: FragmentLawyersOverviewBinding) {
        val adapter = HomePagerAdapter(this)
        binding.pager.adapter = adapter
        TabLayoutMediator(binding.tabs, binding.pager) { tab, position ->
            tab.text = adapter.getTitleAt(position)
            binding.pager.setCurrentItem(tab.position, true)
        }.attach()
    }
}