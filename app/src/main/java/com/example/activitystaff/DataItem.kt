package com.example.activitystaff

import java.io.Serializable
import com.google.gson.annotations.SerializedName

class DataItem : Serializable {
    @field:SerializedName("staff_name")
    val staffName: String? = null

    @field:SerializedName("staff_JK")
    val staffJeniskelamin: String? = null

    @field:SerializedName("staff_PS")
    val staffProgramstudi: String? = null

    @field:SerializedName("staff_hp")
    val staffHp : String? = null

    @field:SerializedName("staff_alamat")
    val staffAlamat: String? = null

}