package com.bitc.project1.mental

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bitc.project1.CookieActivity
import com.bitc.project1.MainActivity
import com.bitc.project1.R
import com.bitc.project1.card.TaroActivity
import com.bitc.project1.databinding.ActivitySimBinding


class SimActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySimBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnsim1.setOnClickListener {
            val intent = Intent(this, SimT1Activity::class.java)
            startActivity(intent)

        }
        binding.btnsim2.setOnClickListener { // 상처회복력테스트
            val intent = Intent(this, SimT2Activity::class.java)
            startActivity(intent)

        }

//        간단 심리테스트
        binding.btnsim3.setOnClickListener {
            val intent = Intent(this, SimT3Activity::class.java)
            startActivity(intent)

        }
        
//        무의식테스트
        binding.btnsim4.setOnClickListener {
            val intent = Intent(this, Test4MainActivity::class.java)
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