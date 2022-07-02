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

        ApiUtils.getApiDaoInterface().getAllStructer().enqueue(
            object : Callback<StructerResponse> {
                override fun onResponse(
                    call: Call<StructerResponse>,
                    response: Response<StructerResponse>
                ) {
                    try {
                        response.body()?.let {

                            val tempList = it.structures
                            structerList.value = tempList
                            for(item in tempList){
                                println("Bina adı(body) : "+item.name)
                            }
                        }


                    }
                    catch (exception : Exception){
                        println(exception)
                    }


                }

                override fun onFailure(call: Call<StructerResponse>, t: Throwable) {
                    println(t.localizedMessage)
                    println("mesaj :"+t.message)
                    println("sebep :"+t.cause)
                }

            }
        )
    }

    fun apisGet() : MutableLiveData<List<Structer>> {
        return structerList
    }

}