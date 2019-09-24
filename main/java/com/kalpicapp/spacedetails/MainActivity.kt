package com.kalpicapp.spacedetails

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kalpicapp.spacedetails.Supplier.isromission
import kotlinx.android.synthetic.main.list_view_layout.*
import kotlinx.android.synthetic.main.main_layout.*
import kotlinx.android.synthetic.main.mission_details_layout.*
import java.util.*


class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

//        textView.setOnClickListener {
//
//            Toast.makeText(this, "Button Was Clicked ! Button Was Clicked !", Toast.LENGTH_SHORT).show()
//
//        }

        setupRecyclerView()

        // Usage:

        recyclerView.addOnItemClickListener(object: OnItemClickListener {
            @SuppressLint("ResourceType")
            override fun onItemClicked(position: Int, view: View) {

//                val numid = isromission[position]

//                Toast.makeText(applicationContext, " $position and $view ", Toast.LENGTH_SHORT).show()
                // Your logic
//                val message: String = "Hello Message"
                val intent = Intent(applicationContext, MissionDetails::class.java)
                intent.putExtra("KEY_msg",position)
                startActivity(intent)







            }
        })

    }


    private fun setupRecyclerView(){

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val adapter = MissionAdapter(this,isromission)
        recyclerView.adapter = adapter

    }

    interface OnItemClickListener {
        fun onItemClicked(position: Int, view: View)
    }


    fun RecyclerView.addOnItemClickListener(onClickListener: OnItemClickListener) {
        this.addOnChildAttachStateChangeListener(object: RecyclerView.OnChildAttachStateChangeListener {
            override fun onChildViewDetachedFromWindow(view: View) {
                view.setOnClickListener(null)
            }

            override fun onChildViewAttachedToWindow(view: View) {
                view.setOnClickListener {
                    val holder = getChildViewHolder(view)
                    onClickListener.onItemClicked(holder.adapterPosition, view)
                }
            }
        })
    }



}





