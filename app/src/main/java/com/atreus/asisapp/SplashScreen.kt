package com.atreus.asisapp

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.VideoView

class SplashScreen : AppCompatActivity() {
    var videoView: VideoView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(1)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        window.statusBarColor = Color.TRANSPARENT
        setContentView(R.layout.activity_splash_screen)

        videoView = findViewById(R.id.videoview)

        val path = "android.resource://" + packageName + "/" + R.raw.animasisplashscreen
        val uri = Uri.parse(path)
        videoView!!.setVideoURI(uri)
        videoView!!.start()

        videoView!!.setOnCompletionListener {
            if (isFinishing) {
                true
            }
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }


}