package com.bitc.project1.mental

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bitc.project1.CookieActivity
import com.bitc.project1.MainActivity
import com.bitc.project1.R
import com.bitc.project1.card.TaroActivity
import com.bitc.project1.databinding.ActivitySimT1ResultBinding
import com.bitc.project1.databinding.ActivityTaroBinding


class SimT1ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySimT1ResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.btnBack.setOnClickListener {
//            val intent = Intent(this,SimT1QuestActivity::class.java)
//            startActivity(intent)
//        }
        binding.backtoSimList.setOnClickListener {
            val intent = Intent(this, SimActivity::class.java)
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