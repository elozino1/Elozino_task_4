package com.example.elozino_task_4

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class RecyclerViewAdapter(var names: List<String>, var images: List<Int>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.celebrant_name)
        val profileImageView: ShapeableImageView = view.findViewById(R.id.celebrant_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.birthdays_recycler_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = names[position]
        val image = images[position]
        holder.nameTextView.text = name
        holder.profileImageView.setImageResource(image)
    }

    override fun getItemCount(): Int {
        return names.size
    }
}