package com.atreus.asisapp.onboarding.Screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.atreus.asisapp.R


class ThridScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_thrid_screen, container, false)

        val viewPager2 = activity?.findViewById<ViewPager2>(R.id.viewpager)

        view.findViewById<ImageView>(R.id.nextsc3).setOnClickListener {
            viewPager2?.currentItem = 3
        }

        view.findViewById<ImageView>(R.id.backsc3).setOnClickListener {
            viewPager2?.currentItem = 1
        }

        return view
    }


}