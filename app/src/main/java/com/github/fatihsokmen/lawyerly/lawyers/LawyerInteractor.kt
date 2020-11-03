package com.github.fatihsokmen.lawyerly.lawyers

import com.github.fatihsokmen.lawyerly.data.LawyerDomain
import com.github.fatihsokmen.lawyerly.data.Repository

class LawyerInteractor(
    private val repository: Repository
) {

    suspend fun getLawyers(): List<LawyerDomain> =
        repository.getAllLawyers()
}