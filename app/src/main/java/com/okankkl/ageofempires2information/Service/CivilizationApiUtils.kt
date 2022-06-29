package com.okankkl.ageofempires2information.Service

class CivilizationApiUtils {

    companion object{

        private const val BASE_URL = "https://age-of-empires-2-api.herokuapp.com/api/v1/"

        fun getCivilizationApiDaoInterface() : CivilizationApiDAOInterface{
            return RetrofitClient.getClient(BASE_URL).create(CivilizationApiDAOInterface::class.java)
        }

    }

}