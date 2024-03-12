package com.bitc.project1.mental

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bitc.project1.databinding.ActivitySimT2QuestBinding


class SimT2QuestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySimT2QuestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, SimT2ResultActivity::class.java)
            startActivity(intent)
        }
    }
}