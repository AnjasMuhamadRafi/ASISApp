package com.atreus.asisapp.Home.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.atreus.asisapp.R
import com.atreus.asisapp.TestPomo


class Home : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cvpomo : CardView = view.findViewById(R.id.Cv_Pomo)
        cvpomo.setOnClickListener {
            val CVpomo = Intent(this@Home.activity, TestPomo::class.java)
            startActivity(CVpomo)
        }

    }

}