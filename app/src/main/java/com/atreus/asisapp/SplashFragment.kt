package com.atreus.asisapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController



class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (OnBoardingFinished()){
            findNavController().navigate(R.id.action_splashFragment_to_homeActivity)
        }else{
            findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash2, container, false)
    }
    private fun OnBoardingFinished() : Boolean{
        val sharedPref = requireActivity().getSharedPreferences("OnBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }

}