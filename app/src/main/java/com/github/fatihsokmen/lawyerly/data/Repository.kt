package com.github.fatihsokmen.lawyerly.data

interface Repository {

    suspend fun getAllLawyers(): List<LawyerDomain>
}