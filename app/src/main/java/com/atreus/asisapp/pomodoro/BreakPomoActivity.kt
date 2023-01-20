package com.atreus.asisapp.pomodoro

import android.content.Intent
import android.media.MediaPlayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.atreus.asisapp.R

class BreakPomoActivity : AppCompatActivity() {
    private var progressBarBreak: ProgressBar? = null
    private var progressTextBreak: TextView? = null
    private var cdTimerBreak: CountDownTimer? = null
    private var breakBtn: Button? = null

    companion object{
        const val EXTRA_BREAK = "extra_break"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_break_pomo)
        val nilai = intent.getIntExtra(EXTRA_BREAK,0)
        progressBarBreak = findViewById(R.id.progress_bar_break)
        progressTextBreak = findViewById(R.id.progress_text_break)
        progressBarBreak!!.setProgress(100)
        supportActionBar!!.hide()
        if (nilai != null){
            startPomoBreak(nilai)
        }else{
            var toast = Toast.makeText(applicationContext,"Waktu Break Null" + nilai, Toast.LENGTH_LONG)
            toast.show()
        }
        breakBtn!!.setOnClickListener {
            endBreak()
        }


    }
    private fun startPomoBreak (value : Int){
        var toast = Toast.makeText(applicationContext,"value" + value, Toast.LENGTH_LONG)
        toast.show()
        cdTimerBreak = object : CountDownTimer( (60 * value * 1000).toLong(), 1000) {
            // fungsi ontick dijalankan setiap 500ms
            override fun onTick(leftTimeInMilliseconds: Long) {
                var mLeftTimeMilis = (60 * value * 1000).toLong()
                mLeftTimeMilis = leftTimeInMilliseconds
                val seconds = leftTimeInMilliseconds / 1000
                progressBarBreak!!.setMax(value * 60)
                progressBarBreak!!.setProgress(seconds.toInt())
                progressTextBreak!!.setText(
                    String.format("%02d", seconds / 60) + ":" + String.format(
                        "%02d",
                        seconds % 60
                    )
                )
                // format the textview to show the easily readable format
            }

            override fun onFinish() {
                val player : MediaPlayer = MediaPlayer.create(this@BreakPomoActivity, R.raw.alarm_sound)
                player.start()
                var toast =
                    Toast.makeText(applicationContext,"Break Time Over, back to Pomodoro !", Toast.LENGTH_LONG)
                toast.show()
                val handler = Handler()
                handler.postDelayed({
                    val intent = Intent(this@BreakPomoActivity, PomoActivity::class.java)
                    startActivity(intent)
                    player.stop()
                }, 2000)

            }
        }.start()
    }
    private fun endBreak(){
        cdTimerBreak?.cancel()
        val intent = Intent(this@BreakPomoActivity, PomoActivity::class.java)
        startActivity(intent)
    }
}