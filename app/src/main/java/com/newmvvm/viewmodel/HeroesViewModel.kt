package com.newmvvm.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.newmvvm.model.Hero
import android.arch.lifecycle.LiveData
import android.util.Log
import android.widget.Toast
import com.newmvvm.successs
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit





class HeroesViewModel : ViewModel(),successs.prese {



    private var heroList: MutableLiveData<List<Hero>>? = null
    var successs: successs? = null




    fun getHeroes(): LiveData<List<Hero>> {
        //if the list is null
        if (heroList == null) {
            heroList = MutableLiveData<List<Hero>>()
            //we will load it asynchronously from server in this method
            loadHeroes()
        }

        //finally we will return the list
        return heroList as MutableLiveData<List<Hero>>
    }

    private fun loadHeroes() {

        val retrofit = Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Api::class.java!!)
        val call = api.getHeroes()


        call.enqueue(object : Callback<List<Hero>> {
            override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) {
                //finally we are setting the list to our MutableLiveData
                heroList!!.setValue(response.body())
            }
            override fun onFailure(call: Call<List<Hero>>, t: Throwable) {
                Log.d("error", t.toString())

            }
        })
    }
}