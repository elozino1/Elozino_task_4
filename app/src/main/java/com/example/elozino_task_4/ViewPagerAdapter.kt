package com.example.elozino_task_4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter (private val messages: List<Int>, private val images: List<Int>) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    inner class ViewHolder(cardView: View) : RecyclerView.ViewHolder(cardView) {
        private val birthdayMessage: TextView = cardView.findViewById(R.id.birthday_message)
        private val imageHolder: ImageView = cardView.findViewById(R.id.image)

        fun initialize(message: Int, image:Int) {
            birthdayMessage.setText(message)
            imageHolder.setImageResource(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_pager, parent, false)
        return ViewHolder(view)
    }

    //bind data to the textview to display message and imageview to display each celebrant's image
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = messages[position]
        val image = images[position]
        holder.initialize(message, image)
    }

    override fun getItemCount(): Int {
        return messages.size
    }
}