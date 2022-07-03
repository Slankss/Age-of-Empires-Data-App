package com.okankkl.ageofempires2information.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.okankkl.ageofempires2information.Model.Structer
import com.okankkl.ageofempires2information.Model.Unite
import com.okankkl.ageofempires2information.Repository.StructerRepository
import com.okankkl.ageofempires2information.Repository.UnitRepository

class UnitViewModel : ViewModel(){

    private val apiRepo = UnitRepository()

    var apiList = MutableLiveData<List<Unite>>()

    init {
        getUnits()
        apiList = apiRepo.apisGet()
    }

    private fun getUnits() {
        apiRepo.getApis()
    }


}