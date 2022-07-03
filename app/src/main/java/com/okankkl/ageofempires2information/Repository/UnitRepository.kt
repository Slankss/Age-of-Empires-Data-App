package com.okankkl.ageofempires2information.Repository

import androidx.lifecycle.MutableLiveData
import com.okankkl.ageofempires2information.Model.Structer
import com.okankkl.ageofempires2information.Model.Unite
import com.okankkl.ageofempires2information.Response.StructerResponse
import com.okankkl.ageofempires2information.Response.UnitResponse
import com.okankkl.ageofempires2information.Service.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UnitRepository {
    val unitList = MutableLiveData<List<Unite>>()

    init {
        getApis()
    }

    fun getApis(){

        ApiUtils.getApiDaoInterface().getAllUnit().enqueue(
            object : Callback<UnitResponse> {
                override fun onResponse(
                    call: Call<UnitResponse>,
                    response: Response<UnitResponse>
                ) {
                    try {
                        response.body()?.let {

                            val tempList = it.units
                            unitList.value = tempList

                        }


                    }
                    catch (exception : Exception){
                        println(exception)
                    }


                }

                override fun onFailure(call: Call<UnitResponse>, t: Throwable) {
                    println(t.localizedMessage)
                }

            }
        )
    }

    fun apisGet() : MutableLiveData<List<Unite>> {
        return unitList
    }

}