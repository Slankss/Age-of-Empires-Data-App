package com.okankkl.ageofempires2information.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.okankkl.ageofempires2information.Model.Civilization
import com.okankkl.ageofempires2information.Model.Structer
import com.okankkl.ageofempires2information.Repository.CivilizationRepository
import com.okankkl.ageofempires2information.Repository.StructerRepository

class StructerViewModel : ViewModel() {

    private val apiRepo = StructerRepository()

    var apiList = MutableLiveData<List<Structer>>()

    init {
        getStructers()
        apiList = apiRepo.apisGet()
    }

    private fun getStructers() {
        apiRepo.getApis()
    }

}