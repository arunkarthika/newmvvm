package com.newmvvm.Navigation


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.newmvvm.R
import kotlinx.android.synthetic.main.fragment_mainfargment.*
import kotlinx.android.synthetic.main.fragment_mainfargment.view.*


class Mainfargment : Fragment() {
    lateinit var button: Button
    private lateinit var button2: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_mainfargment, container, false)





    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        home.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.settingfra)
        }

        settings.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_mainfargment_to_account) }
    }

}
