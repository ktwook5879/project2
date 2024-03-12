package com.bitc.project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import com.bitc.project1.card.TaroActivity
import com.bitc.project1.databinding.ActivityFortuneMainBinding
import com.bitc.project1.newyear.DogActivity
import com.bitc.project1.newyear.DragonActivity
import com.bitc.project1.newyear.GoatActivity
import com.bitc.project1.newyear.HorseActivity
import com.bitc.project1.newyear.MonkeyActivity
import com.bitc.project1.newyear.OxActivity
import com.bitc.project1.newyear.PigActivity
import com.bitc.project1.newyear.RabbitActivity
import com.bitc.project1.newyear.RatActivity
import com.bitc.project1.newyear.RoosterActivity
import com.bitc.project1.newyear.SnakeActivity
import com.bitc.project1.newyear.TigerActivity
import com.bitc.project1.zodiac.AquariusActivity
import com.bitc.project1.zodiac.AriesActivity
import com.bitc.project1.zodiac.CancerActivity
import com.bitc.project1.zodiac.CapricornActivity
import com.bitc.project1.zodiac.GeminiActivity
import com.bitc.project1.zodiac.LeoActivity
import com.bitc.project1.zodiac.LibraActivity
import com.bitc.project1.zodiac.PiscesActivity
import com.bitc.project1.zodiac.SagittariusActivity
import com.bitc.project1.zodiac.ScorpioActivity
import com.bitc.project1.zodiac.TaurusActivity
import com.bitc.project1.zodiac.VirgoActivity
import com.google.android.material.card.MaterialCardView

class FortuneMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFortuneMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val datePicker: DatePicker = binding.datePicker
        val secondCardView1: MaterialCardView = binding.secondCardView1
        val secondCardView2: MaterialCardView = binding.secondCardView2

        secondCardView1.setOnClickListener {
            val selectedYear = datePicker.year
            val chineseZodiac = getChineseZodiac(selectedYear)
            startActivityForAnimal(chineseZodiac)
        }

        secondCardView2.setOnClickListener {
            val selectedMonth = datePicker.month + 1
            val selectedDay = datePicker.dayOfMonth

            if (selectedDay != null) {
                val zodiacSign = getZodiacSign(selectedMonth, selectedDay)
                startActivityForZodiac(zodiacSign)
            }
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

    private fun getZodiacSign(month: Int, day: Int): String {
        when (month) {
            1 -> return if (day <= 20) "Capricorn" else "Pisces"
            2 -> return if (day <= 19) "Pisces" else "Aquarius"
            3 -> return if (day <= 20) "Aquarius" else "Aries"
            4 -> return if (day <= 20) "Aries" else "Taurus"
            5 -> return if (day <= 21) "Taurus" else "Gemini"
            6 -> return if (day <= 21) "Gemini" else "Cancer"
            7 -> return if (day <= 22) "Cancer" else "Leo"
            8 -> return if (day <= 23) "Leo" else "Virgo"
            9 -> return if (day <= 23) "Virgo" else "Libra"
            10 -> return if (day <= 23) "Libra" else "Scorpio"
            11 -> return if (day <= 22) "Scorpio" else "Sagittarius"
            12 -> return if (day <= 21) "Sagittarius" else "Capricorn"
        }
        return "zodiacSign"
    }

    private fun getChineseZodiac(year: Int): String {
        val zodiacIndex = (year - 4) % 12
        val zodiacArray = resources.getStringArray(R.array.chinese_zodiac)
        return zodiacArray[zodiacIndex]
    }

    private fun startActivityForZodiac(zodiacSign: String) {
        val intent = when (zodiacSign) {
            "Pisces" -> Intent(this, AquariusActivity::class.java)
            "Aquarius" -> Intent(this, PiscesActivity::class.java)
            "Aries" -> Intent(this, AriesActivity::class.java)
            "Taurus" -> Intent(this, TaurusActivity::class.java)
            "Gemini" -> Intent(this, GeminiActivity::class.java)
            "Cancer" -> Intent(this, CancerActivity::class.java)
            "Leo" -> Intent(this, LeoActivity::class.java)
            "Virgo" -> Intent(this, VirgoActivity::class.java)
            "Libra" -> Intent(this, LibraActivity::class.java)
            "Scorpio" -> Intent(this, ScorpioActivity::class.java)
            "Sagittarius" -> Intent(this, SagittariusActivity::class.java)
            "Capricorn" -> Intent(this, CapricornActivity::class.java)
            else -> Intent(this, FortuneMainActivity::class.java)
        }
        startActivity(intent)
    }

    private fun startActivityForAnimal(chineseZodiac: String) {
        val intent = when (chineseZodiac) {
            "Rat" -> Intent(this, RatActivity::class.java)
            "Ox" -> Intent(this, OxActivity::class.java)
            "Tiger" -> Intent(this, TigerActivity::class.java)
            "Rabbit" -> Intent(this, RabbitActivity::class.java)
            "Dragon" -> Intent(this, DragonActivity::class.java)
            "Snake" -> Intent(this, SnakeActivity::class.java)
            "Horse" -> Intent(this, HorseActivity::class.java)
            "Goat" -> Intent(this, GoatActivity::class.java)
            "Monkey" -> Intent(this, MonkeyActivity::class.java)
            "Rooster" -> Intent(this, RoosterActivity::class.java)
            "Dog" -> Intent(this, DogActivity::class.java)
            "Pig" -> Intent(this, PigActivity::class.java)
            else -> Intent(this, FortuneMainActivity::class.java)
        }
        startActivity(intent)
    }
}