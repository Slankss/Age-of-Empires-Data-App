package com.okankkl.ageofempires2information.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.okankkl.ageofempires2information.Model.Structer

data class StructerResponse (

    @SerializedName("structures")
    @Expose var structures : List<Structer>

)
