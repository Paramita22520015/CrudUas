package com.example.activitystaff

import android.security.identity.AccessControlProfileId
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

object NetworkConfig {
    fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return okHttpClient
    }

    //Retrofit
    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2/server_api/index.php/ServerApi/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    fun getService() = getRetrofit().create(StaffService::class.java)
}
    interface StaffService {
        //fungsi create data
        @FormUrlEncoded
        @POST("addStaff")
        fun addstaff(@Field("name") name: String,
                     @Field("Jeniskelamin") Jeniskelamin: String,
                     @Field("ProgramStudi") Programstudi: String,
            @Field("hp") hp: String,
            @Field("alamat") alamat : String) : Call<ResultStatus>

        //fungsi get data
        @GET("getDataStaff")
        fun getData() : Call<ResultStaff>

        //fungsi update data
        @FormUrlEncoded
        @POST("updateStaff")
        fun updateStaff(@Field("id") id: String,
                        @Field("name") name: String,
                        @Field("Jeniskelamin") Jeniskelamin: String,
                        @Field("ProgramStudi") Programstudi: String,
                        @Field("hp") hp: String,
                        @Field("alamat") alamat : String) : Call<ResultStatus>

        //fungsi delete
        @FormUrlEncoded
        @POST("deleteStaff")
         fun deleteStaff(@Field("id") id: String?): Call<ResultStatus>
    }