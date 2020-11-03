package com.github.fatihsokmen.lawyerly.core.module

import com.github.fatihsokmen.lawyerly.data.HardCodedRepository
import com.github.fatihsokmen.lawyerly.data.Repository
import org.koin.core.module.Module
import org.koin.dsl.module

val dataModule: Module = module {

    single<Repository> {
        HardCodedRepository()
    }
}