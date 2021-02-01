package com.example.thenamequiz.adapter

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thenamequiz.model.Person
import java.util.*


class PersonAdapter(val personList: ArrayList<Person>) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imageViewName = itemView.findViewById(R.id.imageViewName) as ImageView
        val textViewName = itemView.findViewById(R.id.textViewName) as TextView
        val deleteButton = itemView.findViewById(R.id.deleteButton) as Button
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.person_view, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val person: Person = personList[position]

        holder.imageViewName.setImageBitmap(person.image)
        holder.textViewName.text = person.name
        holder.deleteButton.setOnClickListener{
            personList.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
        }

    }

    fun removeKitten(view: View, position: Int){
        personList.removeAt(position)
        notifyItemRemoved(position)
    }
}
