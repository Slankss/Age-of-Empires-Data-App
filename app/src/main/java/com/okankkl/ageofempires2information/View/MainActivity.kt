package com.okankkl.ageofempires2information.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.okankkl.ageofempires2information.Adapter.CivilizationRecyclerAdapter
import com.okankkl.ageofempires2information.R

class MainActivity : AppCompatActivity() {

    lateinit var bottom : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(CivilizationListFragment())
        bottom = findViewById(R.id.bottomNavigation) as BottomNavigationView

        bottom.setOnNavigationItemSelectedListener {
            when (it.itemId) {

                R.id.civilizations -> loadFragment(CivilizationListFragment())
                R.id.structers -> loadFragment(UnitFragment())
                //
            }
            true
        }


    }

    private fun loadFragment(fragment : Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.navHost,fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }
}