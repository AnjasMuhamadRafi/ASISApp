package com.atreus.asisapp.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.atreus.asisapp.R
import com.atreus.asisapp.adapter.HabitListAdapter
import com.atreus.asisapp.data.model.habitListData
import com.atreus.asisapp.view.activity.HabitDetailActivity


class HabitList : Fragment() {
    companion object {
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_habit_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val habitList = view.findViewById<RecyclerView>(R.id.rv_habitfix)
        habitList.adapter = HabitListAdapter(activity, habitListData) {
            val intent = Intent(activity, HabitDetailActivity::class.java)
            intent.putExtra(HabitDetailActivity.INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
}