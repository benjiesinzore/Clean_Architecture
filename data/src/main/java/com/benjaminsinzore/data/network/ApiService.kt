package com.benjaminsinzore.data.network

import com.benjaminsinzore.comons.Constance
import com.benjaminsinzore.data.network.model.BlogsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {

//    suspend fun getBlogs() : Response<BlogsDTO>




    @GET("post")
    suspend fun getBlogs(
        @Header("app-id") appId:String= Constance.APP_ID
    ) : Response<BlogsDTO>
}