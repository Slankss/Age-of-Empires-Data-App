package com.okankkl.ageofempires2information.Service

import com.okankkl.ageofempires2information.Model.Civilization
import com.okankkl.ageofempires2information.Response.CivilizationApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CivilizationApiDAOInterface {

    @GET("civilizations")
    fun getAllApis() : Call<CivilizationApiResponse>

    @GET("civilization/{id}")
    fun getCivilization(@Path("id") id : Int) : Call<Civilization>

}