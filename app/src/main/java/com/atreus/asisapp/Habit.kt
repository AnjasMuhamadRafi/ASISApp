package com.example.nyobahabitroom

import android.os.Parcelable
import android.widget.ImageView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "habit_table")
@Parcelize
data class Habit(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "image") var image: Int,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "quantity") var quantity: Int
): Parcelable
val habitListData = listOf<Habit>(
    Habit(
        1,
        "Workout",
        R.drawable.workout,
        "Workout every day to keep your body fit and your mind fresher",
        1,
    ),
    Habit(
        2,
        "Drink Water",
        R.drawable.drink_water,
        "Drink water at least 2 liter of water every day regularly to keep the body well hydrated",
        1,
    ),
    Habit(
        3,
        "Eat",
        R.drawable.eat,
        "Eat three times a day with healthy food to keep your body fresh dan healthy",
        1,
    ),
    Habit(
        4,
        "Take a Pill",
        R.drawable.take_a_pill,
        "Set reminder to help you take your pill at a right time",
        1,
    ),
    Habit(
        5,
        "Spend Time with Family",
        R.drawable.spend_time_with_family,
        "Spend time with family make your soul feel at ease and relaxed",
        1,
    ),
    Habit(
        6,
        "Socialized with Friends",
        R.drawable.socialized_with_friend,
        "Chat with friends and go to event together can make your mind at ease",
        1,
    ),
    Habit(
        7,
        "Pray",
        R.drawable.pray,
        "Don’t forget to pray and be grateful everyday for what you have until now",
        1,
    ),
    Habit(
        8,
        "Sleep Early",
        R.drawable.sleep_early,
        "Going to bed early makes body more energetic and healthier",
        1,
    ),
    Habit(
        9,
        "Wake Up Early",
        R.drawable.wake_up_early,
        "Get up early and live your day happily",
        1,
    ),
    Habit(
        10,
        "Charity",
        R.drawable.charity,
        "Sharing with those in need can give happiness to life",
        1,
    ),
    Habit(
        11,
        "Do House Work",
        R.drawable.do_house_work,
        "Cleaning the house and do some course can increase productivity",
        1,
    ),
    Habit(
        12,
        "Saving Money",
        R.drawable.saving_money,
        "Sharing with those in need can give happiness to life",
        1,
    ),
    Habit(
        13,
        "Read a Book",
        R.drawable.read_a_book,
        "Start with one book, and you will see the whole new world",
        1,
    ),
    Habit(
        14,
        "Shopping",
        R.drawable.shopping,
        "Little bit of shopping may relief your stress",
        1,
    ),
)