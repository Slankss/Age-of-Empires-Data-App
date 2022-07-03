package com.okankkl.ageofempires2information.Service

import com.okankkl.ageofempires2information.Model.Civilization
import com.okankkl.ageofempires2information.Model.Structer
import com.okankkl.ageofempires2information.Response.CivilizationResponse
import com.okankkl.ageofempires2information.Response.StructerResponse
import com.okankkl.ageofempires2information.Response.UnitResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiDAOInterface {

    @GET("civilizations")
    fun getAllApis() : Call<CivilizationResponse>

    @GET("civilization/{id}")
    fun getCivilization(@Path("id") id : Int) : Call<Civilization>

    @GET("structures")
    fun getAllStructure() : Call<StructerResponse>

    @GET("structure/{id}")
    fun getStructure(@Path("id") id : Int) : Call<Structer>

    @GET("units")
    fun getAllUnit() : Call<UnitResponse>


}