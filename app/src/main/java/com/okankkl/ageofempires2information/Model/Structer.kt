package com.okankkl.ageofempires2information.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class  Structer (

    @SerializedName("id") @Expose var id : Int,
    @SerializedName("name") @Expose var name : String,
    @SerializedName("age") @Expose var age : String,
    @SerializedName("cost") @Expose var cost : HashMap<String,Any>,
    @SerializedName("hit_points") @Expose var hit_points : Int,
    @SerializedName("line_of_sight") @Expose var line_of_sight : Int,
    //@SerializedName("armor") @Expose var armor : String,
    @SerializedName("special") @Expose var special : ArrayList<String>,
    //@SerializedName("range") @Expose var range : Int?,
    @SerializedName("attack") @Expose var attack : Int?,
    @SerializedName("reload_time") @Expose var reload_time : Int?,


        ) : Serializable