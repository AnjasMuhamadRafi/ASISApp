package com.atreus.asisapp.home.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.atreus.asisapp.databinding.FragmentHomeBinding
import com.atreus.asisapp.pomodoro.PomoActivity

class Home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentHomeBinding.inflate(layoutInflater)

        bind.CvPomo.setOnClickListener{
            val intent = Intent (this@Home.requireContext(), PomoActivity::class.java)
            startActivity(intent)
        }
        return bind.root
    }
}