package com.example.activitystaff

import android.util.Log
import retrofit2.Call
import retrofit2.Response

class Presenter2 (val crudView: UpdateAddActivity){
    //Add data
    fun addData(name: String, Jeniskelamin: String,Programstudi: String  ,hp: String, alamat: String){
        NetworkConfig.getService()
            .addstaff(name,Jeniskelamin, Programstudi ,hp, alamat)
            .enqueue(object : retrofit2.Callback<ResultStatus>{
                override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                    crudView.onErrorAdd(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultStatus>, response: Response<ResultStatus>
                ) {
                    if (response.isSuccessful && response.body()?.status == 200) {
                        crudView.onSuccessAdd(response.body()?.pesan ?: "")
                    } else {
                        crudView.onErrorAdd(response.body()?.pesan ?: "")
                    }
                }
            })

    }
    // update data
    fun updateData(id: String, name: String,Jeniskelamin: String,Programstudi: String ,hp: String, alamat: String){
        NetworkConfig.getService()
            .updateStaff(id, name,Jeniskelamin, Programstudi, hp, alamat)
            .enqueue(object : retrofit2.Callback<ResultStatus>{
                override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                    crudView.onErrorUpdate(t.localizedMessage)
                }

                override fun onResponse(call: Call<ResultStatus>, response: Response<ResultStatus>
                ) {
                    if (response.isSuccessful && response.body()?.status == 200) {
                        crudView.onSuccessUpdate(response.body()?.pesan ?: "")
                    } else {
                        crudView.onErrorUpdate(response.body()?.pesan ?: "")
                    }
                }
            })
    }
}