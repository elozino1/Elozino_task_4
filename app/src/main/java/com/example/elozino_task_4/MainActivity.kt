package com.example.elozino_task_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val messageArray = listOf(
            R.string.victor_message,
            R.string.ronke_message,
            R.string.jude_message
        )

        val nameArray = listOf(
            "Ola Machiavelli",
            "Samuel Garfield",
            "Kome Holmes",
            "Omolade Rogers"
        )

        val images = listOf(
            R.drawable.ola,
            R.drawable.samuel,
            R.drawable.holmes,
            R.drawable.omolade
        )

        val viewPagerAdapter = ViewPagerAdapter(messageArray)
        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
        viewPager.adapter = viewPagerAdapter

        val recyclerViewAdapter = RecyclerViewAdapter(nameArray, images)
        val birthdayRecycler = findViewById<RecyclerView>(R.id.recycler_view)
        birthdayRecycler.adapter = recyclerViewAdapter
        birthdayRecycler.layoutManager = LinearLayoutManager(this)
    }
}