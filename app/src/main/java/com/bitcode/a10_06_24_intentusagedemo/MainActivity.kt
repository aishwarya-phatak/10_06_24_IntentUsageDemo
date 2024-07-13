package com.bitcode.a10_06_24_intentusagedemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.StrictMode
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bitcode.a10_06_24_intentusagedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder().build())

        activityMainBinding.showImage.setOnClickListener {
                val intent = Intent("com.bitcode.action.media.VIEW")
//                    intent.action = Intent.ACTION_VIEW
                    intent.setDataAndType(Uri.parse("file://${activityMainBinding.edtPath.text.toString()}"),
                        "image/jpeg")
                startActivity(intent)
        }

        activityMainBinding.playAudio.setOnClickListener{
            val intent = Intent("com.bitcode.action.media.VIEW")
//            intent.action = "Intent.ACTION_VIEW"
            intent.addCategory("com.bitcode.category.TECHNICAL")
            intent.setDataAndType(Uri.parse("file://${activityMainBinding.edtPath.text.toString()}"),
                "audio/mp3")
            startActivity(intent)
        }

        activityMainBinding.playVideo.setOnClickListener {
            val intent = Intent("com.bitcode.action.media.VIEW")
            intent.addCategory("com.bitcode.category.TECHNICAL")
            intent.setDataAndType(Uri.parse("file://${activityMainBinding.edtPath.text.toString()}"),
                "video/mp4")
        }



    }
}