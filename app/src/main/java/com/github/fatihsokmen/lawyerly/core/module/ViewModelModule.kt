package com.github.fatihsokmen.lawyerly.core.module

import com.github.fatihsokmen.lawyerly.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {

    viewModel {
        HomeViewModel(interactor = get())
    }
}