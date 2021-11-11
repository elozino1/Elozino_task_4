package com.example.elozino_task_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //list of congratulatory images
        val messageArray = listOf(
            R.string.sonia_message,
            R.string.ronke_message,
            R.string.victor_message
        )

        //list of celebrants' images
        val celebrantImages = listOf(
            R.drawable.person1,
            R.drawable.person2,
            R.drawable.person3
        )

        //list of upcoming birthday celebrants' names
        val nameArray = listOf(
            "Ola Machiavelli",
            "Samuel Garfield",
            "Kome Holmes",
            "Omolade Rogers"
        )

        //list of upcoming birthday celebrants' images
        val images = listOf(
            R.drawable.ola,
            R.drawable.samuel,
            R.drawable.holmes,
            R.drawable.omolade
        )

        val viewPagerAdapter = ViewPagerAdapter(messageArray, celebrantImages)
        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)
        viewPager.adapter = viewPagerAdapter

        //set scroll transformation on view pager
        viewPager.setPadding(88, 0, 88, 0)
        viewPager.clipToPadding = false
        viewPager.clipChildren = false
        viewPager.offscreenPageLimit = 3
        viewPager.getChildAt(0).overScrollMode = View.OVER_SCROLL_NEVER
        val viewPageTransformer = CompositePageTransformer()
        viewPageTransformer.addTransformer(MarginPageTransformer(45))
        viewPageTransformer.addTransformer { page, position ->
            page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
        }
        viewPager.setPageTransformer(viewPageTransformer)

        val recyclerViewAdapter = RecyclerViewAdapter(nameArray, images)
        val birthdayRecycler = view.findViewById<RecyclerView>(R.id.recycler_view)
        birthdayRecycler.adapter = recyclerViewAdapter
        birthdayRecycler.layoutManager = LinearLayoutManager(this.context)
    }
}