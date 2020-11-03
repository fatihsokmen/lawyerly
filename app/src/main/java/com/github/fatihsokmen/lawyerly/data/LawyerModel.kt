package com.github.fatihsokmen.lawyerly.data

data class LawyerModel(
    val name: String,
    val surname: String,
    val accountVerified: Boolean,
    val speciality: String,
    val rateText: String,
    val ratingText: String,
    val ranking: String,
    val memberSince: String,
    val averageResponseTime: String,
    val info: Info
) {
    data class Info(
        val description: String,
        val other: String
    )
}