package com.atreus.asisapp.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.atreus.asisapp.home.fragment.Habit
import com.atreus.asisapp.home.fragment.Home
import com.atreus.asisapp.home.fragment.Profile
import com.atreus.asisapp.home.fragment.Work
import com.atreus.asisapp.R
import com.atreus.asisapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.nav_home -> replaceFragment(Home())
                R.id.nav_work -> replaceFragment(Work())
                R.id.nav_habit -> replaceFragment(Habit())
                R.id.nav_profile -> replaceFragment(Profile())

                else ->{

                    }

                }
                true
            }

        }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}