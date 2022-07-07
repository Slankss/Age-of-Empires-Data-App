package com.okankkl.ageofempires2information.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.okankkl.ageofempires2information.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.apply {
            Handler().postDelayed(
                {
                    val intent  = Intent(this@SplashActivity,MainActivity::class.java)
                    startActivity(intent)

                }, 3000
            )
        }


    }
}