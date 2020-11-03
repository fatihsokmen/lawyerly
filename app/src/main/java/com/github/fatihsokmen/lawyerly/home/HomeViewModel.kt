package com.github.fatihsokmen.lawyerly.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.github.fatihsokmen.lawyerly.core.livedata.LiveEvent
import com.github.fatihsokmen.lawyerly.data.LawyerDomain
import com.github.fatihsokmen.lawyerly.data.LawyerModel
import com.github.fatihsokmen.lawyerly.data.toModel
import com.github.fatihsokmen.lawyerly.lawyers.LawyerInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val interactor: LawyerInteractor
) : ViewModel() {

    private val allLawyerDomains = MutableLiveData<List<LawyerDomain>>()

    val allLawyerModels = allLawyerDomains.map { lawyers ->
        lawyers.map { it.toModel() }
    }

    val featuredLawyerModels = allLawyerDomains.map { lawyers ->
        lawyers.filter { lawyer -> lawyer.rating >= 4.5 }.map { lawyer -> lawyer.toModel() }
    }

    val favoriteLawyerModels = allLawyerDomains.map { lawyers ->
        lawyers.filter { lawyer -> lawyer.rating >= 4.8 }.map { lawyer -> lawyer.toModel() }
    }

    val onLawyerSelected = LiveEvent<LawyerModel>()

    val selectedLawyer = onLawyerSelected.map {
        it
    }

    init {
        loadLawyers()
    }

    private fun loadLawyers() {
        viewModelScope.launch {
            allLawyerDomains.value = withContext(Dispatchers.IO) {
                interactor.getLawyers()
            }
        }
    }

}