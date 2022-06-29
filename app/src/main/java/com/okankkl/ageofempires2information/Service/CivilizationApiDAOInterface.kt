package com.okankkl.ageofempires2information.Service

import com.okankkl.ageofempires2information.Response.CivilizationApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface CivilizationApiDAOInterface {

    @GET("civilizations")
    fun getAllApis() : Call<CivilizationApiResponse>

}