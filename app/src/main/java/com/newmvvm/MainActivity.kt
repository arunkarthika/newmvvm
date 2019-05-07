package com.newmvvm

import android.app.ProgressDialog
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.newmvvm.viewmodel.HeroesViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.RecyclerView
import com.newmvvm.model.Hero
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.newmvvm.Adapter.HeroesAdapter


class MainActivity : AppCompatActivity() {
lateinit var  adapter: HeroesAdapter
lateinit var  recyclerView:RecyclerView
    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        progressDialog=ProgressDialog(this)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager=layoutManager
        val model:HeroesViewModel=ViewModelProviders.of(this).get(HeroesViewModel::class.java)
        progressDialog!!.show()
        progressDialog!!.setMessage("Loading")


        model.getHeroes().observe(this,
            Observer<List<Hero>> { heroList ->
                adapter = HeroesAdapter(this@MainActivity, heroList)
                recyclerView.setAdapter(adapter)
                progressDialog!!.dismiss()
                Toast.makeText(this,"success", Toast.LENGTH_LONG)
            })
    }
}
