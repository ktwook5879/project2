package com.bitc.project1.card

import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import com.bitc.project1.MainActivity
import com.bitc.project1.R
import com.bitc.project1.databinding.ActivityTaroBinding
import com.bitc.project1.CookieActivity
import kotlin.random.Random

class TaroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTaroBinding.inflate(layoutInflater)
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

        val cardImage1: ImageView = findViewById(R.id.cardImage1)
        val cardImage2: ImageView = findViewById(R.id.cardImage2)
        val cardImage3: ImageView = findViewById(R.id.cardImage3)
        val cardImage4: ImageView = findViewById(R.id.cardImage4)
        val cardImage5: ImageView = findViewById(R.id.cardImage5)
        val cardImage6: ImageView = findViewById(R.id.cardImage6)
        val cardImage7: ImageView = findViewById(R.id.cardImage7)
        val cardImage8: ImageView = findViewById(R.id.cardImage8)
        val cardImage9: ImageView = findViewById(R.id.cardImage9)
        val cardImage10: ImageView = findViewById(R.id.cardImage10)
        val cardImage11: ImageView = findViewById(R.id.cardImage11)
        val cardImage12: ImageView = findViewById(R.id.cardImage12)
        val cardImage13: ImageView = findViewById(R.id.cardImage13)
        val cardImage14: ImageView = findViewById(R.id.cardImage14)
        val cardImage15: ImageView = findViewById(R.id.cardImage15)


        // 터치 이벤트 처리
        cardImage1.setOnTouchListener { view, event ->
            handleTouch(view, event)
        }

        cardImage2.setOnTouchListener { view, event ->
            handleTouch(view, event)
        }
        cardImage3.setOnTouchListener { view, event ->
            handleTouch(view, event)
        }

        cardImage4.setOnTouchListener { view, event ->
            handleTouch(view, event)
        }

        cardImage5.setOnTouchListener { view, event ->
            handleTouch(view, event)
        }

        cardImage6.setOnTouchListener { view, event ->
            handleTouch(view, event)
        }

        cardImage7.setOnTouchListener { view, event ->
            handleTouch(view, event)
        }

        cardImage8.setOnTouchListener { view, event ->
            handleTouch(view, event)
        }

        cardImage9.setOnTouchListener { view, event ->
            handleTouch(view, event)
        }

        cardImage10.setOnTouchListener { view, event ->
            handleTouch(view, event)
        }

        cardImage11.setOnTouchListener { view, event ->
            handleTouch(view, event)
        }

        cardImage12.setOnTouchListener { view, event ->
            handleTouch(view, event)
        }

        cardImage13.setOnTouchListener { view, event ->
            handleTouch(view, event)
        }

        cardImage14.setOnTouchListener { view, event ->
            handleTouch(view, event)
        }

        cardImage15.setOnTouchListener { view, event ->
            handleTouch(view, event)
        }

        // 추가적인 이미지뷰를 필요에 따라 터치 이벤트 처리
    }

    private fun handleTouch(view: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                animateView(view, -20f, 1.1f, 0.7f)
            }

            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                animateView(view, 0f, 1f, 1f)


                // 랜덤한 Activity로 이동
                val randomActivity = getRandomActivity()
                val intent = Intent(this, randomActivity)
                startActivity(intent)
            }
        }
        return true
    }

    private fun animateView(view: View, translationY: Float, scaleX: Float, alpha: Float) {
        val animator = ValueAnimator.ofFloat(view.translationY, translationY)
        animator.addUpdateListener { valueAnimator ->
            view.translationY = valueAnimator.animatedValue as Float
            view.scaleX = scaleX
            view.scaleY = scaleX
            view.alpha = alpha
        }
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.duration = 200
        animator.start()
    }

    private fun getRandomActivity(): Class<*> {
        // 여러 개의 Activity 중에서 랜덤하게 하나를 선택
        val activities = arrayOf(
            FoolActivity::class.java, MagicianActivity::class.java, PriestessActivity::class.java, ChariotActivity::class.java, CupsActivity::class.java, DeathActivity::class.java, DevilActivity::class.java, EmperorActivity::class.java, FortuneActivity::class.java, HangedManActivity::class.java, HermitActivity::class.java, HierophantActivity::class.java, JudgementActivity::class.java, JusticeActivity::class.java, LoversActivity::class.java, MoonActivity::class.java, PentaclesActivity::class.java, StarActivity::class.java, StrengthActivity::class.java, SunActivity::class.java, SwordsActivity::class.java, TemperanceActivity::class.java, TowerActivity::class.java, WandsActivity::class.java, WorldActivity::class.java, CupActivity2::class.java, CupActivity3::class.java, CupActivity4::class.java, CupActivity5::class.java, CupActivity6::class.java, CupActivity7::class.java, CupActivity8::class.java, CupActivity9::class.java, CupActivity10::class.java, CupActivityKing::class.java, CupActivityKnight::class.java, CupActivityPage::class.java, CupActivityQueen::class.java, SwordsActivity2::class.java, SwordsActivity3::class.java, SwordsActivity4::class.java, SwordsActivity5::class.java, SwordsActivity6::class.java, SwordsActivity7::class.java, SwordsActivity8::class.java, SwordsActivity9::class.java, SwordsActivity10::class.java, SwordsActivityKing::class.java, SwordsActivityKnight::class.java, SwordsActivityQueen::class.java, SwordsActivityPage::class.java, WandsActivity2::class.java, WandsActivity3::class.java, WandsActivity4::class.java, WandsActivity5::class.java, WandsActivity6::class.java, WandsActivity7::class.java, WandsActivity8::class.java, WandsActivity9::class.java, WandsActivity10::class.java, WandsActivityKing::class.java, WandsActivityKnight::class.java, WandsActivityQueen::class.java, WandsActivityPage::class.java, PentaclesActivity2::class.java, PentaclesActivity3::class.java, PentaclesActivity4::class.java, PentaclesActivity5::class.java, PentaclesActivity6::class.java, PentaclesActivity7::class.java, PentaclesActivity8::class.java, PentaclesActivity9::class.java, PentaclesActivity10::class.java, PentaclesActivityKing::class.java, PentaclesActivityKnight::class.java, PentaclesActivityPage::class.java, PentaclesActivityQueen::class.java)

        val randomIndex = Random.nextInt(activities.size)

        return activities[randomIndex]

    }
}
