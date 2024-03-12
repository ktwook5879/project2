package com.bitc.project1.mbti.es

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.project1.R
import com.bitc.project1.databinding.ActivityMbtiEntpactivityBinding
import com.bitc.project1.databinding.ActivityMbtiEstpactivityBinding
import com.bitc.project1.mbti.MbtiMainActivity
import com.bitc.project1.mbti.QuizActivity

class MbtiESTPActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMbtiEstpactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mbtihome.setOnClickListener {
            val intent = Intent(this, MbtiMainActivity::class.java)
            startActivity(intent)
        }
    }
}