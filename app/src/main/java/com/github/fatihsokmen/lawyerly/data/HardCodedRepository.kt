package com.github.fatihsokmen.lawyerly.data

class HardCodedRepository : Repository {

    override suspend fun getAllLawyers(): List<LawyerDomain> =
        lawyers

    companion object {
        private val lawyers = listOf(
            LawyerDomain(
                name = "Name",
                surname = "Surname",
                accountVerified = true,
                speciality = "Immigration",
                rate = 55.9,
                rating = 4.8,
                ranking = "1/18",
                memberSince = "Oct 2015",
                averageResponseTime = "1 day",
                info = LawyerDomain.Info(description = "He is a very good lawyer", other = "N/A")
            ),
            LawyerDomain(
                name = "Name",
                surname = "Surname",
                accountVerified = true,
                speciality = "Divorce",
                rate = 50.0,
                rating = 4.6,
                ranking = "1/9",
                memberSince = "Nov 2015",
                averageResponseTime = "1 day",
                info = LawyerDomain.Info(description = "He is a very good lawyer", other = "N/A")
            ),
            LawyerDomain(
                name = "Name",
                surname = "Surname",
                accountVerified = false,
                speciality = "Business",
                rate = 53.7,
                rating = 4.2,
                ranking = "1/9",
                memberSince = "Oct 2015",
                averageResponseTime = "2 days",
                info = LawyerDomain.Info(description = "He is a very good lawyer", other = "N/A")
            ),
            LawyerDomain(
                name = "Name",
                surname = "Surname",
                accountVerified = true,
                speciality = "Immigration",
                rate = 55.0,
                rating = 5.0,
                ranking = "1/22",
                memberSince = "Jan 2015",
                averageResponseTime = "1 day",
                info = LawyerDomain.Info(description = "He is a very good lawyer", other = "N/A")
            ),
            LawyerDomain(
                name = "Name",
                surname = "Surname",
                accountVerified = false,
                speciality = "Divorce",
                rate = 45.0,
                rating = 4.0,
                ranking = "1/20",
                memberSince = "May 2015",
                averageResponseTime = "3 days",
                info = LawyerDomain.Info(description = "He is a very good lawyer", other = "N/A")
            ),
            LawyerDomain(
                name = "Name",
                surname = "Surname",
                accountVerified = true,
                speciality = "Criminal",
                rate = 36.0,
                rating = 4.4,
                ranking = "1/10",
                memberSince = "Apr 2015",
                averageResponseTime = "1 day",
                info = LawyerDomain.Info(description = "He is a very good lawyer", other = "N/A")
            ),
            LawyerDomain(
                name = "Name",
                surname = "Surname",
                accountVerified = true,
                speciality = "Immigration",
                rate = 51.4,
                rating = 3.7,
                ranking = "1/12",
                memberSince = "Jan 2015",
                averageResponseTime = "1 day",
                info = LawyerDomain.Info(description = "He is a very good lawyer", other = "N/A")
            ),
            LawyerDomain(
                name = "Name",
                surname = "Surname",
                accountVerified = false,
                speciality = "Business",
                rate = 65.0,
                rating = 4.5,
                ranking = "1/17",
                memberSince = "Aug 2015",
                averageResponseTime = "1 day",
                info = LawyerDomain.Info(description = "He is a very good lawyer", other = "N/A")
            ),
            LawyerDomain(
                name = "Name",
                surname = "Surname",
                accountVerified = true,
                speciality = "Business",
                rate = 58.8,
                rating = 4.4,
                ranking = "1/18",
                memberSince = "Nov 2015",
                averageResponseTime = "1 day",
                info = LawyerDomain.Info(description = "He is a very good lawyer", other = "N/A")
            ),
        )
    }
}

