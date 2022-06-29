package com.okankkl.ageofempires2information.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.okankkl.ageofempires2information.Model.Civilization
import com.okankkl.ageofempires2information.Repository.CivilizationApiRepository

class CivilizationViewModel : ViewModel() {

    private val apiRepo = CivilizationApiRepository()

    var apiList = MutableLiveData<List<Civilization>>()

    init {
        getCivilizations()
        apiList = apiRepo.apisGet()
    }

    private fun getCivilizations() {
        apiRepo.getApis()
    }

}