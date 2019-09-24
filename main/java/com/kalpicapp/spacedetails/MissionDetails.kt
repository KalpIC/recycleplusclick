package com.kalpicapp.spacedetails


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kalpicapp.spacedetails.Supplier.isromission
import kotlinx.android.synthetic.main.mission_details_layout.*

class MissionDetails : AppCompatActivity(){

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mission_details_layout)


        val bundle: Bundle? = intent.extras

        bundle?.let {


            val msg = bundle.getInt("KEY_msg")

            val mdetails = isromission[msg].details

            detail_text.text = " msg here $mdetails "



    }



    }
}