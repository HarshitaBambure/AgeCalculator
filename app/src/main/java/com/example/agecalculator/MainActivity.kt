package com.example.agecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView  // declaration
    private lateinit var recyclerAdapter: UserAadpter // declaration
    private var dataList = mutableListOf<User>() // declaration with assignment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv_recyclerView) // find view and assign
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)//layout manager
        dataList.add(User(dataList.size+1,0,0)) //add list item
        recyclerAdapter = UserAadpter(dataList) //adapter initalization
        recyclerView.adapter = recyclerAdapter //adapter set

        iv_plus.setOnClickListener {
            dataList.add(User(dataList.size+1,0,0))  //one item added on click of plus
            recyclerAdapter.notifyItemInserted(dataList.size-1) //notify to adapter and update ui
            txt_total_person.text=dataList.size.toString() // set account for no. of items
        }

        iv_minus.setOnClickListener {
            if(dataList.size>1) {  //if one item remain then no need to remove item.
                dataList.removeAt(dataList.size - 1) //remove item.
                recyclerAdapter.notifyItemRemoved(dataList.size + 1) //notify to adapter of item remove and update ui
                txt_total_person.text = dataList.size.toString() //set account for no. of list
            }else if(dataList.size==1) {
                dataList.clear()  //clear item
                dataList.add(User(dataList.size+1,0,0)) // add user
                recyclerAdapter.notifyDataSetChanged() //notify to adapter and update ui
                txt_total_person.text = dataList.size.toString()
            }
        }

    }



}