package com.github.fatihsokmen.lawyerly

import android.app.Application
import com.github.fatihsokmen.lawyerly.core.module.dataModule
import com.github.fatihsokmen.lawyerly.core.module.viewModelModule
import com.github.fatihsokmen.lawyerly.lawyers.lawyerModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    dataModule, viewModelModule, lawyerModule
                )
            )
        }
    }
}