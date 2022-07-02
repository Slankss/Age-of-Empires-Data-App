package com.okankkl.ageofempires2information.Repository

import androidx.lifecycle.MutableLiveData
import com.okankkl.ageofempires2information.Model.Structer
import com.okankkl.ageofempires2information.Response.StructerResponse
import com.okankkl.ageofempires2information.Service.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StructerRepository {

    val structerList = MutableLiveData<List<Structer>>()

    init {
        getApis()
    }

    fun getApis(){

        ApiUtils.getApiDaoInterface().getAllStructure().enqueue(
            object : Callback<StructerResponse> {
                override fun onResponse(
                    call: Call<StructerResponse>,
                    response: Response<StructerResponse>
                ) {
                    try {
                        response.body()?.let {

                            val tempList = it.structures
                            structerList.value = tempList

                        }


                    }
                    catch (exception : Exception){
                        println(exception)
                    }


                }

                override fun onFailure(call: Call<StructerResponse>, t: Throwable) {
                    println(t.localizedMessage)
                }

            }
        )
    }

    fun apisGet() : MutableLiveData<List<Structer>> {
        return structerList
    }

}