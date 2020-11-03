package com.github.fatihsokmen.lawyerly.data

fun LawyerDomain.toModel() =
    LawyerModel(
        name = name,
        surname = surname,
        accountVerified = accountVerified,
        speciality = speciality,
        rateText = "£${rate}/h",
        ratingText = "$rating",
        ranking = ranking,
        memberSince = memberSince,
        averageResponseTime = averageResponseTime,
        info = LawyerModel.Info(
            description = info?.description.orEmpty(),
            other = info?.other.orEmpty()
        )
    )

