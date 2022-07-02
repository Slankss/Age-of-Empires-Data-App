package com.okankkl.ageofempires2information.Repository

import androidx.lifecycle.MutableLiveData
import com.okankkl.ageofempires2information.Model.Civilization
import com.okankkl.ageofempires2information.Response.CivilizationResponse
import com.okankkl.ageofempires2information.Service.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CivilizationRepository {

    val civilizationList  = MutableLiveData<List<Civilization>>()


    init {
        getApis()
    }

    fun getApis(){

        ApiUtils.getApiDaoInterface().getAllApis().enqueue(
            object : Callback<CivilizationResponse> {
                override fun onResponse(
                    call: Call<CivilizationResponse>,
                    response: Response<CivilizationResponse>
                ) {
                    try {
                        response.body()?.let {
                            val tempList = it.civilization
                            civilizationList.value = tempList
                        }

                    }
                    catch (exception : Exception){
                        println(exception)
                    }


                }

                override fun onFailure(call: Call<CivilizationResponse>, t: Throwable) {}

            }
        )
    }

    fun apisGet() : MutableLiveData<List<Civilization>> {
        return civilizationList
    }

}