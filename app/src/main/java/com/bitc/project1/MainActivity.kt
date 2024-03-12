package com.bitc.project1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.os.Message
import androidx.viewpager2.widget.ViewPager2
import com.bitc.project1.card.TaroActivity
import com.bitc.project1.databinding.ActivityMainBinding
import com.bitc.project1.dream.DreamMainActivity
import com.bitc.project1.mbti.MbtiMainActivity
import com.bitc.project1.mental.SimActivity
import com.bitc.project1.zodiac2.ConMainActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var list = mutableListOf(R.drawable.newyear_banner, R.drawable.today_fortune_banner, R.drawable.mind_test_banner)
    private var numBanner = 3
    private var currentPosition = Int.MAX_VALUE / 2
    private var myHandler = MyHandler()
    private val intervalTime = 2000.toLong() // 몇초 간격으로 페이지를 넘길것인지 (1500 = 1.5초)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.autoScrollViewPager.adapter = InfiniteAdapter(list)
        binding.autoScrollViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.autoScrollViewPager.setCurrentItem(currentPosition, false)

        binding.autoScrollViewPager.apply {
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {


                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    when (state) {
                        // 뷰페이저에서 손 떼었을때 / 뷰페이저 멈춰있을 때
                        ViewPager2.SCROLL_STATE_IDLE -> autoScrollStart(intervalTime)
                        // 뷰페이저 움직이는 중
                        ViewPager2.SCROLL_STATE_DRAGGING -> autoScrollStop()
                    }
                }
            })
        }

        binding.btnStellar.setOnClickListener {
            val intent = Intent(this, ConMainActivity::class.java)
            startActivity(intent)
        }

        binding.btnMbti.setOnClickListener {
            val intent = Intent(this, MbtiMainActivity::class.java)
            startActivity(intent)
        }

        binding.btnPsychology.setOnClickListener {
            val intent = Intent(this, SimActivity::class.java)
            startActivity(intent)
        }

        binding.btnTaro.setOnClickListener {
            val intent = Intent(this, TaroActivity::class.java)
            startActivity(intent)
        }

        binding.btnNewyear.setOnClickListener {
            val intent = Intent(this, FortuneMainActivity::class.java)
            startActivity(intent)
        }

        binding.btnDream.setOnClickListener {
            val intent = Intent(this, DreamMainActivity::class.java)
            startActivity(intent)
        }

        binding.btnCookie.setOnClickListener {
            val intent = Intent(this, CookieActivity::class.java)
           startActivity(intent)
        }


    }
    private fun autoScrollStart(intervalTime: Long) {
        myHandler.removeMessages(0) // 이거 안하면 핸들러가 1개, 2개, 3개 ... n개 만큼 계속 늘어남
        myHandler.sendEmptyMessageDelayed(0, intervalTime) // intervalTime 만큼 반복해서 핸들러를 실행하게 함
    }

    private fun autoScrollStop(){
        myHandler.removeMessages(0) // 핸들러를 중지시킴
    }

    private inner class MyHandler : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            if(msg.what == 0) {
                binding.autoScrollViewPager.setCurrentItem(++currentPosition, true) // 다음 페이지로 이동
                autoScrollStart(intervalTime) // 스크롤을 계속 이어서 한다.
            }
        }
    }

    // 다른 페이지 갔다가 돌아오면 다시 스크롤 시작
    override fun onResume() {
        super.onResume()
        autoScrollStart(intervalTime)
    }

    // 다른 페이지로 떠나있는 동안 스크롤이 동작할 필요는 없음. 정지
    override fun onPause() {
        super.onPause()
        autoScrollStop()
    }
}







