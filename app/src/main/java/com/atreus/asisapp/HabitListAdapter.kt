package com.example.nyobahabitroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView

class HabitListAdapter(
    private val context: FragmentActivity?,
    private val habit: List<Habit>,
    private val listener: (Habit) -> Unit
): RecyclerView.Adapter<HabitListAdapter.HabitViewHolder>() {
    class HabitViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val habitImg = view.findViewById<ImageView>(R.id.rv_imageViewList)
        val habitTitle = view.findViewById<TextView>(R.id.rv_tvHabitList)

        fun bindView(Habit: Habit, listener: (Habit) -> Unit) {
            habitImg.setImageResource(Habit.image)
            habitTitle.text = Habit.title
            itemView.setOnClickListener {
                listener(Habit)
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