package com.atreus.asisapp.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.atreus.asisapp.onboarding.Screen.FirstScreen
import com.atreus.asisapp.onboarding.Screen.FourthScreen
import com.atreus.asisapp.onboarding.Screen.SecondScreen
import com.atreus.asisapp.onboarding.Screen.ThridScreen
import com.atreus.asisapp.R

class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThridScreen(),
            FourthScreen()

        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle

        )

        view.findViewById<ViewPager2>(R.id.viewpager).adapter = adapter

        return view
    }


}