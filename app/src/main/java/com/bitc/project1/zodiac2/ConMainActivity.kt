package com.bitc.project1.zodiac2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.project1.CookieActivity
import com.bitc.project1.MainActivity
import com.bitc.project1.R
import com.bitc.project1.card.TaroActivity
import com.bitc.project1.databinding.ActivityConMainBinding

class ConMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityConMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.yumso.setOnClickListener {
            val intent = Intent(this, yumsoActivity::class.java)
            startActivity(intent)
        }
        binding.yang.setOnClickListener {
            val intent = Intent(this, yangActivity::class.java)
            startActivity(intent)
        }
        binding.sasu.setOnClickListener {
            val intent = Intent(this, sasuActivity::class.java)
            startActivity(intent)
        }
        binding.mulgogi.setOnClickListener {
            val intent = Intent(this, MulgogiActivity::class.java)
            startActivity(intent)
        }
        binding.mul.setOnClickListener {
            val intent = Intent(this, MulbyeongActivity::class.java)
            startActivity(intent)
        }
        binding.ge.setOnClickListener {
            val intent = Intent(this, GeActivity::class.java)
            startActivity(intent)
        }
        binding.ssang.setOnClickListener {
            val intent = Intent(this, SsangActivity::class.java)
            startActivity(intent)
        }
        binding.saza.setOnClickListener {
            val intent = Intent(this, SazeActivity::class.java)
            startActivity(intent)
        }
        binding.virgin.setOnClickListener {
            val intent = Intent(this, VirginActivity::class.java)
            startActivity(intent)
        }
        binding.cheon.setOnClickListener {
            val intent = Intent(this, CheonActivity::class.java)
            startActivity(intent)
        }
        binding.jeongal.setOnClickListener {
            val intent = Intent(this, JeonGalActivity::class.java)
            startActivity(intent)
        }
        binding.hwang.setOnClickListener {
            val intent = Intent(this, HwangsoActivity::class.java)
            startActivity(intent)
        }

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