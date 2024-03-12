package com.bitc.project1.zodiac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.project1.CookieActivity
import com.bitc.project1.MainActivity
import com.bitc.project1.R
import com.bitc.project1.card.TaroActivity
import com.bitc.project1.databinding.ActivityAriesBinding
import com.bitc.project1.databinding.ActivityScorpioBinding

class ScorpioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityScorpioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavi.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.bottom1 -> {
                    startActivity(Intent(this, TaroActivity::class.java))
                    finish()
                    true
                }

                R.id.bottom2 -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                    true
                }

                R.id.bottom3 -> {
                    startActivity(Intent(this, CookieActivity::class.java))
                    true
                }

                else -> false
            }
        }
    }
}