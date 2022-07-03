package com.okankkl.ageofempires2information.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Unite (

    @SerializedName("id") @Expose var id : Int,
    @SerializedName("name") @Expose var name : String,
    @SerializedName("description") @Expose var description : String,
    @SerializedName("age") @Expose var age : String,
    @SerializedName("cost") @Expose var cost : HashMap<String,Any>,
    @SerializedName("build_time") @Expose var build_time : Int,
    @SerializedName("hit_points") @Expose var hit_points : Int,
    @SerializedName("reload_time") @Expose var reload_time : Float,
    @SerializedName("attack_delay") @Expose var attack_delay : Float,
    @SerializedName("movement_rate") @Expose var movement_rate : Float,
    @SerializedName("line_of_sight") @Expose var line_of_sight : Int,
    @SerializedName("attack") @Expose var attack : Int,
    @SerializedName("attack_bonus") @Expose var attack_bonus : ArrayList<String>,
    @SerializedName("accuracy") @Expose var accuracy : String,
    @SerializedName("armor") @Expose var armor : String


) : Serializable