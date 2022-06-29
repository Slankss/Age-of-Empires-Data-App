package com.okankkl.ageofempires2information.Repository

import androidx.lifecycle.MutableLiveData
import com.okankkl.ageofempires2information.Model.Civilization
import com.okankkl.ageofempires2information.Response.CivilizationApiResponse
import com.okankkl.ageofempires2information.Service.CivilizationApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CivilizationApiRepository {

    val civilizationList  = MutableLiveData<List<Civilization>>()

    init {
        getApis()
    }

    fun getApis(){

        CivilizationApiUtils.getCivilizationApiDaoInterface().getAllApis().enqueue(
            object : Callback<CivilizationApiResponse> {
                override fun onResponse(
                    call: Call<CivilizationApiResponse>,
                    response: Response<CivilizationApiResponse>
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

                override fun onFailure(call: Call<CivilizationApiResponse>, t: Throwable) {}

            }
        )
    }

    fun apisGet() : MutableLiveData<List<Civilization>> {
        return civilizationList
    }

}