package com.atreus.asisapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.atreus.asisapp.R
import com.atreus.asisapp.data.model.HabitData

class HabitListAdapter(
    private val context: FragmentActivity?,
    private val habit: List<HabitData>,
    private val listener: (HabitData) -> Unit
): RecyclerView.Adapter<HabitListAdapter.HabitViewHolder>() {
    class HabitViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val habitImg = view.findViewById<ImageView>(R.id.rv_imageViewList)
        val habitTitle = view.findViewById<TextView>(R.id.rv_tvHabitList)

        fun bindView(HabitData: HabitData, listener: (HabitData) -> Unit) {
            habitImg.setImageResource(HabitData.image)
            habitTitle.text = HabitData.title
            itemView.setOnClickListener {
                listener(HabitData)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        return HabitViewHolder(
            LayoutInflater.from(context).inflate(R.layout.recyclerview_habit_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        holder.bindView(habit[position], listener)
    }

    override fun getItemCount(): Int = habit.size
}