package com.bitc.project1.mbti.`is`

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.project1.R
import com.bitc.project1.databinding.ActivityMbtiEntpactivityBinding
import com.bitc.project1.databinding.ActivityMbtiIstpactivityBinding
import com.bitc.project1.mbti.MbtiMainActivity
import com.bitc.project1.mbti.QuizActivity

class MbtiISTPActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMbtiIstpactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mbtihome.setOnClickListener {
            val intent = Intent(this, MbtiMainActivity::class.java)
            startActivity(intent)
        }
    }
}