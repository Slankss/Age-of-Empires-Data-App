package com.okankkl.ageofempires2information.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.okankkl.ageofempires2information.Model.Civilization

data class CivilizationResponse (

    @SerializedName("civilizations")
    @Expose var civilization : List<Civilization>

    )