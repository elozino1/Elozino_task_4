package com.example.elozino_task_4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter (val messages: List<Int>, val images: List<Int>) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    inner class ViewHolder(cardView: View) : RecyclerView.ViewHolder(cardView) {
        val birthdayMessage: TextView = cardView.findViewById(R.id.birthday_message)
        val imageHolder: ImageView = cardView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_pager, parent, false)
        return ViewHolder(view)
    }

    //bind data to the textview to display message and imageview to display each celebrant's image
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = messages[position]
        val image = images[position]
        holder.birthdayMessage.setText(message)
        holder.imageHolder.setImageResource(image)
    }

    override fun getItemCount(): Int {
        return messages.size
    }
}