package com.bitc.project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.project1.databinding.ActivityBottomNaviBinding

class BottomNaviActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBottomNaviBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.bottom1 -> {
                    startActivity(Intent(this, FortuneMainActivity::class.java))
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