package com.atreus.asisapp.OnBoarding.Screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.atreus.asisapp.R


class FourthScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fourth_screen, container, false)

        val viewPager2 = activity?.findViewById<ViewPager2>(R.id.viewpager)

        view.findViewById<ImageView>(R.id.backsc4).setOnClickListener {
            viewPager2?.currentItem = 2
        }

        view.findViewById<TextView>(R.id.finish).setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeActivity)
            OnBoardingFinished()
        }

        return view
    }

    private fun OnBoardingFinished(){
        val sharedPref = requireActivity().getSharedPreferences("OnBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }


}