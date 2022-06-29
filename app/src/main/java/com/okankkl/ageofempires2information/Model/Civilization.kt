package com.okankkl.ageofempires2information.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Civilization(

    @SerializedName("id") @Expose var id : Int,
    @SerializedName("name") @Expose var name : String,
    @SerializedName("expansion") @Expose var expansion : String,
    @SerializedName("army_type") @Expose var army_type : String,
    @SerializedName("unique_tech") @Expose var unique_tech : ArrayList<String>,
    @SerializedName("civilization_bonus") @Expose var civilization_bonus : ArrayList<String>,
    @SerializedName("team_bonus") @Expose var team_bonus : String


) : Serializable