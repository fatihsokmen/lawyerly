package com.github.fatihsokmen.lawyerly.lawyers

import androidx.annotation.IntDef

@Retention(AnnotationRetention.SOURCE)
@IntDef(ALL, FAVOURITES, FEATURED)
annotation class LawyerFilter

const val ALL = 0
const val FAVOURITES = 1
const val FEATURED = 2