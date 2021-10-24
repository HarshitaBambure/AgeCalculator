package com.example.agecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: UserAadpter
    private var dataList = mutableListOf<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv_recyclerView)
        //grid layout manager
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        dataList.add(User(dataList.size+1,0,0))
        recyclerAdapter = UserAadpter(dataList)
        recyclerView.adapter = recyclerAdapter

        iv_plus.setOnClickListener {
            dataList.add(User(dataList.size+1,0,0))
            recyclerAdapter.notifyItemInserted(dataList.size-1)
            txt_total_person.text=dataList.size.toString()
        }

        iv_minus.setOnClickListener {
            if(dataList.size>1) {
                dataList.removeAt(dataList.size - 1)
                recyclerAdapter.notifyItemRemoved(dataList.size + 1)
                txt_total_person.text = dataList.size.toString()
            }else if(dataList.size==1) {
                dataList.clear()
                dataList.add(User(dataList.size+1,0,0))
                recyclerAdapter.notifyDataSetChanged()
                txt_total_person.text = dataList.size.toString()
            }
        }

    }



}