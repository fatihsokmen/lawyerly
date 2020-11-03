package com.github.fatihsokmen.lawyerly.lawyers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.fatihsokmen.lawyerly.R
import com.github.fatihsokmen.lawyerly.data.LawyerModel
import com.github.fatihsokmen.lawyerly.databinding.ViewLawyerBinding
import com.github.fatihsokmen.lawyerly.home.HomeViewModel

class LawyerListAdapter(
    private val lawyers: List<LawyerModel>,
    private val viewModel: HomeViewModel
) : RecyclerView.Adapter<LawyerListAdapter.LawyerViewHolder>() {

    private val handler =
        object : LawyerSelectionHandler {
            override fun onLawyerClicked(lawyer: LawyerModel) {
                viewModel.onLawyerSelected.call(lawyer)
            }
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LawyerViewHolder {
        val binding = DataBindingUtil.inflate<ViewLawyerBinding>(
            LayoutInflater.from(parent.context),
            R.layout.view_lawyer,
            parent,
            false
        )
        return LawyerViewHolder(binding, handler)
    }

    override fun onBindViewHolder(holder: LawyerViewHolder, position: Int) {
        holder.bind(lawyers[position])
    }

    override fun getItemCount() =
        lawyers.size

    class LawyerViewHolder(
        private val binding: ViewLawyerBinding,
        private val handler: LawyerSelectionHandler
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(lawyer: LawyerModel) {
            binding.lawyer = lawyer
            binding.handler = handler
            binding.executePendingBindings()
        }
    }

    interface LawyerSelectionHandler {
        fun onLawyerClicked(lawyer: LawyerModel)
    }
}