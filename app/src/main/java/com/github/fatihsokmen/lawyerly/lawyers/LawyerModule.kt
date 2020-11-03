package com.github.fatihsokmen.lawyerly.lawyers

import org.koin.core.module.Module
import org.koin.dsl.module

val lawyerModule: Module = module {

    factory {
        LawyerInteractor(repository = get())
    }
}