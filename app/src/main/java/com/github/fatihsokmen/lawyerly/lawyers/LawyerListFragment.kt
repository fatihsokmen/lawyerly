package com.github.fatihsokmen.lawyerly.lawyers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.fatihsokmen.lawyerly.databinding.FragmentLawyersListBinding
import com.github.fatihsokmen.lawyerly.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.lang.IllegalArgumentException

class LawyerListFragment : Fragment() {

    private val viewModel: HomeViewModel by sharedViewModel()

    private lateinit var binding: FragmentLawyersListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLawyersListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt(FILTER_KEY)?.let { filter ->
            val data = when (filter) {
                FEATURED -> viewModel.featuredLawyerModels
                ALL -> viewModel.allLawyerModels
                FAVOURITES -> viewModel.favoriteLawyerModels
                else -> throw IllegalArgumentException("Invalid filter")
            }
            data.observe(viewLifecycleOwner) { lawyers ->
                binding.lawyers.adapter = LawyerListAdapter(
                    lawyers,
                    viewModel
                )
            }
        }
    }

    companion object {
        const val FILTER_KEY = "filter"

        fun newInstance(@LawyerFilter filter: Int): LawyerListFragment {
            val arguments = Bundle()
            arguments.putInt(FILTER_KEY, filter)
            val fragment = LawyerListFragment()
            fragment.arguments = arguments
            return fragment
        }
    }
}