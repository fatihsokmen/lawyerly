package com.github.fatihsokmen.lawyerly.core.databinding

import android.view.View
import androidx.databinding.BindingAdapter

object ViewBindingAdapters {

    @BindingAdapter("visibleWhen")
    @JvmStatic
    fun setVisibility(view: View, value: Boolean) {
        view.visibility = if (value) View.VISIBLE else View.GONE
    }
}