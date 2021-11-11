package com.example.elozino_task_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView

class MainActivity : AppCompatActivity() {
    var homeFragment: HomeFragment = HomeFragment()
    var giftFragment: GiftFragment = GiftFragment()
    var peopleFragment: PeopleFragment = PeopleFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        currentFragment(homeFragment)

        val homeFrag = findViewById<BottomNavigationItemView>(R.id.home_fragment)
        homeFrag.setOnClickListener {
            currentFragment(homeFragment)
        }

        val peopleFrag = findViewById<BottomNavigationItemView>(R.id.people_fragment)
        peopleFrag.setOnClickListener {
            currentFragment(peopleFragment)
        }

        val giftFrag = findViewById<BottomNavigationItemView>(R.id.gifts_fragment)
        giftFrag.setOnClickListener {
            currentFragment(giftFragment)
        }
    }

    private fun currentFragment(fragment: Fragment) {
        if(fragment != null) {
            supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
        }
    }
}