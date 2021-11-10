package com.example.elozino_task_4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter (val messages: List<Int>) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    inner class ViewHolder(cardView: View) : RecyclerView.ViewHolder(cardView) {
        val birthdayMessage: TextView = cardView.findViewById(R.id.birthday_message)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_pager, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = messages[position]
        holder.birthdayMessage.setText(message)
    }

    override fun getItemCount(): Int {
        return messages.size
    }
}