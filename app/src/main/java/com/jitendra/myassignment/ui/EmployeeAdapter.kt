package com.jitendra.myassignment.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jitendra.myassignment.R
import com.jitendra.myassignment.model.Employee

class EmployeeAdapter(private val employees: List<Employee>) :
    RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    class EmployeeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.tvName)
        val team: TextView = view.findViewById(R.id.tvTeam)
        val image: ImageView = view.findViewById(R.id.ivProfile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_employee, parent, false)
        return EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = employees[position]
        holder.name.text = employee.fullName
        holder.team.text = employee.team

        Glide.with(holder.itemView.context)
            .load(employee.photoUrlSmall)
            .placeholder(R.drawable.ic_face)
            .into(holder.image)
    }

    override fun getItemCount(): Int = employees.size
}
