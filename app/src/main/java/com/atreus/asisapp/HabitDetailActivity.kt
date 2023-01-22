package com.example.nyobahabitroom

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class HabitDetailActivity(var habit: Habit?) : AppCompatActivity() {

    private lateinit var habitViewModel: HabitViewModel

    companion object {
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_habit_detail)
        supportActionBar?.hide()
        val habit = intent.getParcelableExtra<Habit>(HabitList.INTENT_PARCELABLE)

        val habitTitle = findViewById<TextView>(R.id.textView_habitdetail_title)
        habitTitle.text = habit?.title
        val habitImg = findViewById<ImageView>(R.id.ivDetailHabit)
        habitImg.setImageResource(habit?.image!!)
        val habitDescription = findViewById<TextView>(R.id.textView_habitdetail)
        habitDescription.text = habit.description

        var quantity = 1
        val btn_increase_quantity = findViewById<ImageButton>(R.id.desc_quantity_increase)
        val btn_decrease_quantity = findViewById<ImageButton>(R.id.desc_quantity_decrease)
        val desc_quantity_value = findViewById<TextView>(R.id.desc_quantity_value)

        btn_increase_quantity.setOnClickListener {
            quantity++
            desc_quantity_value.text = quantity.toString()
        }
        btn_decrease_quantity.setOnClickListener {
            quantity--
            desc_quantity_value.text = quantity.toString()
        }

        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()
        val mFragment = HabitTrack()
        val btn_save = findViewById<Button>(R.id.desc_btnsave)
        btn_save.setOnClickListener {
            val fragment: Fragment? = supportFragmentManager.findFragmentByTag(HabitTrack::class.java.simpleName)
            if (fragment !is HabitTrack) {
                mFragmentTransaction.add(R.id.fragmentnih, mFragment, HabitTrack::class.java.simpleName)
                mFragmentTransaction.commit()
            }

//            val bundle = Bundle()
//            bundle.putParcelable(HabitTrack., habit)
//            mFragment.arguments = bundle
//            mFragmentTransaction.add(R.id.rv_habits, mFragment).commit()
        }
    }

//    private fun addHabitItem(){
//
//        val habitTitle = findViewById<TextView>(R.id.textView_habitdetail_title)
//        val habitImg = findViewById<ImageView>(R.id.ivDetailHabit)
//        val habitDescription = findViewById<TextView>(R.id.textView_habitdetail)
//        val quantity = findViewById<TextView>(R.id.desc_quantity_value)
//        habitViewModel.addHabits(Habit(0, habitTitle.text.toString(), habitImg.id.toInt(), habitDescription.text.toString(), quantity.toString().toInt()))
//    }
}

