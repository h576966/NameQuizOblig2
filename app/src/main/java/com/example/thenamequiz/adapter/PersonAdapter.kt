package com.example.thenamequiz.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thenamequiz.R
import com.example.thenamequiz.model.Person
import com.example.thenamequiz.model.PersonApplication
import com.example.thenamequiz.model.PersonViewModel
import com.example.thenamequiz.model.PersonViewModelFactory


class PersonAdapter(context: Context) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {
    private var persons = emptyList<Person>()
    private val personViewModel: PersonViewModel by viewModels {
        PersonViewModelFactory((application as PersonApplication).repository)
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageViewName = itemView.findViewById(R.id.imageViewName) as ImageView
        val textViewName = itemView.findViewById(R.id.textViewName) as TextView
        val delButton = itemView.findViewById(R.id.delButton) as Button
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.person_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person: Person = persons[position] //check if correct
        holder.imageViewName.setImageBitmap(person.image)
        holder.textViewName.text = person.name
        holder.delButton.setOnClickListener(){
            personList.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
        }

    }


}
