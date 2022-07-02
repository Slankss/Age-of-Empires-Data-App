package com.okankkl.ageofempires2information.Service

class ApiUtils {

    companion object{

        private const val BASE_URL = "https://age-of-empires-2-api.herokuapp.com/api/v1/"

        fun getApiDaoInterface() : ApiDAOInterface{
            return RetrofitClient.getClient(BASE_URL).create(ApiDAOInterface::class.java)
        }

    }

}