package com.atreus.asisapp.pomodoro

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.atreus.asisapp.R

class PomoActivity : AppCompatActivity() {

    private var progressBar: ProgressBar? = null
    private var progressText: TextView? = null
    private var cdTimer: CountDownTimer? = null
    private var mTimerRun: Boolean=false
    private var startBtn: Button? = null
    private var doneBtn: Button? = null
    private var customBtn: TextView? = null
    private var mp : MediaPlayer?= null
    private var waktu :Int ?=null
    private var waktuBreak :Int ?=null
    private lateinit var et_break : EditText
    private lateinit var view : View
    private var mLeftTimeMilis: Long?= null
    private var isPause : Boolean ?=null


    //getter
    fun getWaktuBreak(): Int {
        return waktuBreak!!
    }
    //setter
    fun setWaktuBreak(value: Int) {
        waktuBreak = value
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pomo)
        //declare id of item in layout
        view = View.inflate(this@PomoActivity, R.layout.layout_dialog,null)
        doneBtn = findViewById(R.id.btn_done)
        startBtn = findViewById(R.id.btn_start)
        progressBar = findViewById(R.id.progress_bar)
        progressText = findViewById(R.id.progress_text)
        customBtn = findViewById(R.id.btn_custom_pomo)
        et_break = view.findViewById(R.id.edit_break)
        isPause = false
        //onclick method
        startBtn?.setOnClickListener {
            if (mTimerRun && waktu!=0 && waktu!=0) {
                pauseTimer()
            } else if (!mTimerRun && !isPause!! && waktu!=null) {
                startTimer((60 * waktu!! * 1000).toLong())
            }else if (!mTimerRun && isPause!! && waktu!=null){
                startTimer(mLeftTimeMilis!!)
            }
            else{
                var toast = Toast.makeText(applicationContext,"Nilai tak boleh null", Toast.LENGTH_LONG)
                toast.show()
            }
        }
        doneBtn?.setOnClickListener {
            doneTimer()
        }
        customBtn?.setOnClickListener {
            inputTimer1()
        }
        //handling
        val handler = Handler()
        progressBar!!.setProgress(100)
        supportActionBar!!.hide()
    }
    //
    private fun inputTimer1(){
        val builder = AlertDialog.Builder(this@PomoActivity).create()

        val btnSave = view.findViewById<Button>(R.id.save_btn)
        val et_time = view.findViewById<EditText>(R.id.edit_waktu)

        builder.setView(view)
        btnSave.setOnClickListener {
            builder.dismiss()
            waktu= et_time?.text.toString().toInt()
            setWaktuBreak(et_break?.text.toString().toInt())
        }
        builder.show()
    }


    //fungsi start timer
    private fun startTimer(milis : Long) {
        cdTimer = object : CountDownTimer( milis, 1000) {
            // fungsi ontick dijalankan setiap 500ms
            override fun onTick(leftTimeInMilliseconds: Long) {

                mLeftTimeMilis = leftTimeInMilliseconds
                val seconds = leftTimeInMilliseconds / 1000
                progressBar!!.setMax(waktu!! * 60)
                progressBar!!.setProgress(seconds.toInt())
                progressText!!.setText(
                    String.format("%02d", seconds / 60) + ":" + String.format(
                        "%02d",
                        seconds % 60
                    )
                )
                // format the textview to show the easily readable format
            }

            override fun onFinish() {
                startBtn?.setText("Start")
                val player : MediaPlayer = MediaPlayer.create(this@PomoActivity, R.raw.alarm_sound)
                player.start()
                val handler = Handler()
                handler.postDelayed({
                    if (getWaktuBreak() != null){
                        val intent = Intent(this@PomoActivity, BreakPomoActivity::class.java)
                        intent.putExtra(BreakPomoActivity.EXTRA_BREAK,et_break?.text.toString().toInt())
                        startActivity(intent)
                    }else{
                        var toast =
                            Toast.makeText(applicationContext,"Nilai break tak boleh null", Toast.LENGTH_LONG)
                        toast.show()
                    }
                    player.stop()
                }, 2000)

                doneBtn!!.visibility = View.INVISIBLE
                mTimerRun = false
            }
        }.start()
        mTimerRun = true
        startBtn?.setText("Pause")
        doneBtn!!.visibility = View.VISIBLE
        var params: ConstraintLayout.LayoutParams =
            startBtn!!.layoutParams as ConstraintLayout.LayoutParams
//        params?.setMargins(18, 24, 200, 383)
        startBtn!!.animate().x(18F).y(395F).setDuration(500).start()
        params.leftMargin = 18
        params.topMargin = 395
        startBtn!!.layoutParams =params


    }

    //fungsi pause timer
    private fun pauseTimer() {
        cdTimer?.cancel()
        mTimerRun = false
        isPause = true
        startBtn?.setText("Start")
        doneBtn!!.visibility = View.INVISIBLE
        var params: ConstraintLayout.LayoutParams =
            startBtn!!.layoutParams as ConstraintLayout.LayoutParams
        startBtn!!.animate().x(108F).y(395F).setDuration(500).start()
//        params?.setMargins(108, 24, 108, 383)
        params.leftMargin = 108
        params.topMargin = 395
        startBtn!!.layoutParams =params


    }

    //fungsi done timer
    private fun doneTimer() {
        cdTimer?.cancel()
        mTimerRun = false
        progressText?.setText("STOP")
        startBtn?.setText("Start")
        progressBar!!.setProgress(waktu!! * 60)
        doneBtn!!.visibility = View.INVISIBLE
    }


}