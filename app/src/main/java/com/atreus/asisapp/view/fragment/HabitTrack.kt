package com.atreus.asisapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.util.*


class HabitTrack : Fragment() {

    companion object {
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.atreus.asisapp.R.layout.fragment_habit_track, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewdate: TextView = view.findViewById(com.atreus.asisapp.R.id.habit_track_date)
        val textViewday: TextView = view.findViewById(com.atreus.asisapp.R.id.habit_track_day)
        val simpleDayFormat = SimpleDateFormat("EEEE", Locale.getDefault())
        val simpleDateFormat = SimpleDateFormat("dd MM yyyy", Locale.getDefault())
        val currentDate: String = simpleDateFormat.format(Date())
        textViewdate.text = currentDate
        val currentDay: String = simpleDayFormat.format(Date())
        textViewday.text = currentDay

//        val bundle = arguments
//        val habit = bundle?.getParcelable<HabitData>(INTENT_PARCELABLE)
//        val habitImage = view?.findViewById<ImageView>(R.id.rv_imageViewTrack)
//        habitImage?.setImageResource(habit?.image!!)

        val btn_add = view.findViewById<FloatingActionButton>(com.atreus.asisapp.R.id.fab_add)
        btn_add.setOnClickListener {
            val newFragment: Fragment = HabitList()
            val transaction = requireFragmentManager().beginTransaction()
            transaction.replace(com.atreus.asisapp.R.id.cobafragment, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
            btn_add.visibility = View.GONE
            btn_add.isClickable = false
        }
    }
}