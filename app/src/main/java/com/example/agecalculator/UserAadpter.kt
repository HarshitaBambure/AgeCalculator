package com.example.agecalculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recycler.view.*
import java.text.SimpleDateFormat
import java.util.*

class UserAadpter(var listUser: MutableList<User>) : RecyclerView.Adapter<UserAadpter.UserHolder>() {


    class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(user: User, pos: Int) {
            itemView.personsr_no.text =user.id.toString()
            itemView.dob.setText(user.year.toString())
            itemView.txt_age.setText(user.age.toString())
            itemView.btn_cal.setOnClickListener {
                if(itemView.dob.text.toString().trim().length==0){
                    itemView.dob.setError("Enter Correct Year")
                }else{
                    itemView.txt_age.text = calcAge(itemView.dob.text.toString())
                }
            }
            itemView.default_date.text=currentDate()

        }
        // function for getting current date
        private fun currentDate():String{
            val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy")
            val currentDateAndTime: String = simpleDateFormat.format(Date())
            return currentDateAndTime
        }
            //function for age calculation
        private fun calcAge(input: String): String {
            val year = input.toInt()
            val currentYear = Calendar.getInstance().get(Calendar.YEAR)
            return "You are ${currentYear - year} year(s) old"
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        //here layout inflation will resides
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false) //line will be as it is
        return UserHolder(view)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bindData(
            listUser.get(position),
            position
        ) //create method in viewholder and call that method here
    }

    override fun getItemCount(): Int {
        return listUser.size //always list.size will be there
    }

}