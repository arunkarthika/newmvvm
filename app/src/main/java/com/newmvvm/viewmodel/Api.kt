package com.newmvvm.viewmodel


import com.newmvvm.model.Hero
import retrofit2.Call
import retrofit2.http.GET



interface Api {
companion object{
    val BASE_URL = "https://simplifiedcoding.net/demos/"

}
    @GET("marvel")
    fun getHeroes(): Call<List<Hero>>




}