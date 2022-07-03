package com.okankkl.ageofempires2information.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.okankkl.ageofempires2information.Model.Unite

data class UnitResponse (

    @SerializedName("units")
    @Expose var units : List<Unite>

)