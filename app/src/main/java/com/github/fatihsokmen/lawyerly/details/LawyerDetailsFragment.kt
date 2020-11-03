package com.github.fatihsokmen.lawyerly.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.fatihsokmen.lawyerly.R
import com.github.fatihsokmen.lawyerly.databinding.FragmentLawyerDetailsBinding
import com.github.fatihsokmen.lawyerly.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class LawyerDetailsFragment : Fragment() {

    private val viewModel: HomeViewModel by sharedViewModel()

    private lateinit var binding: FragmentLawyerDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_lawyer_details,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.selectedLawyer.observe(viewLifecycleOwner) {
            binding.lawyer = it
            binding.executePendingBindings()
        }
    }
}