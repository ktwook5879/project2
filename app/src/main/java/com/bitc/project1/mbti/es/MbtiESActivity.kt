package com.bitc.project1.mbti.es

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import com.bitc.project1.R
import com.bitc.project1.databinding.ActivityMbtiEnBinding
import com.bitc.project1.databinding.ActivityMbtiEsBinding
import com.bitc.project1.mbti.QuizActivity

class MbtiESActivity : AppCompatActivity() {
    private var binding: ActivityMbtiEsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 기존의 binding 프로퍼티를 초기화합니다.
        binding = ActivityMbtiEsBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)

        binding!!.backButton.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }
        binding!!.submitButton.setOnClickListener {
            if (isAnyRadioButtonSelected()) {
            val score = calculateScore()
            val pjscore = calculateSNScore()

            if (score > 12 && pjscore > 12) {
                startActivity(Intent(this, MbtiESFJActivity::class.java))
            } else if(score > 12 && pjscore <= 12){
                startActivity(Intent(this, MbtiESFPActivity::class.java))
            } else if(score <= 12 && pjscore > 12){
                startActivity(Intent(this, MbtiESTJActivity::class.java))
            } else {
                startActivity(Intent(this, MbtiESTPActivity::class.java))
            }
            } else {
                Toast.makeText(this, "선택되지 않은 문항이 있습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isAnyRadioButtonSelected(): Boolean {
        // 선택 여부를 확인하고 하나라도 선택되어 있으면 true를 반환
        return binding!!.enradioGroup1.checkedRadioButtonId != -1 &&
                binding!!.enradioGroup2.checkedRadioButtonId != -1 &&
                binding!!.enradioGroup3.checkedRadioButtonId != -1 &&
                binding!!.enradioGroup4.checkedRadioButtonId != -1 &&
                binding!!.enradioGroup5.checkedRadioButtonId != -1 &&
                binding!!.enradioGroup6.checkedRadioButtonId != -1 &&
                binding!!.enradioGroup7.checkedRadioButtonId != -1 &&
                binding!!.enradioGroup8.checkedRadioButtonId != -1 &&
                binding!!.enradioGroup9.checkedRadioButtonId != -1 &&
                binding!!.enradioGroup10.checkedRadioButtonId != -1
    }

    private fun calculateSNScore(): Int {
        var pjscore = 0
        pjscore += getScoreFromRadioButton(binding!!.enradioGroup1)
        pjscore += getScoreFromRadioButton(binding!!.enradioGroup3)
        pjscore += getScoreFromRadioButton(binding!!.enradioGroup6)
        pjscore += getScoreFromRadioButton(binding!!.enradioGroup8)
        pjscore += getScoreFromRadioButton(binding!!.enradioGroup9)

        return pjscore
    }

    private fun calculateScore(): Int {
        var score = 0

        score += getScoreFromRadioButton(binding!!.enradioGroup2)
        score += getScoreFromRadioButton(binding!!.enradioGroup4)
        score += getScoreFromRadioButton(binding!!.enradioGroup5)
        score += getScoreFromRadioButton(binding!!.enradioGroup7)
        score += getScoreFromRadioButton(binding!!.enradioGroup10)

        return score
    }

    private fun getScoreFromRadioButton(radioGroup: RadioGroup): Int {
        // ... (이하 동일)
        val selectedRadioButtonId = radioGroup.checkedRadioButtonId
        return when (selectedRadioButtonId) {
            R.id.enradioButton1_1, R.id.enradioButton2_1, R.id.enradioButton5_1, R.id.enradioButton6_1, R.id.enradioButton7_1, R.id.enradioButton8_1, R.id.enradioButton10_1, R.id.enradioButton3_4, R.id.enradioButton4_4, R.id.enradioButton9_4 -> 4

            R.id.enradioButton1_2, R.id.enradioButton2_2, R.id.enradioButton5_2, R.id.enradioButton6_2, R.id.enradioButton7_2, R.id.enradioButton8_2, R.id.enradioButton10_2, R.id.enradioButton3_3, R.id.enradioButton4_3, R.id.enradioButton9_3 -> 3

            R.id.enradioButton1_3, R.id.enradioButton2_3, R.id.enradioButton5_3, R.id.enradioButton6_3, R.id.enradioButton7_3, R.id.enradioButton8_3, R.id.enradioButton10_3, R.id.enradioButton3_2, R.id.enradioButton4_2, R.id.enradioButton9_2 -> 2

            R.id.enradioButton1_4, R.id.enradioButton2_4, R.id.enradioButton5_4, R.id.enradioButton6_4, R.id.enradioButton7_4, R.id.enradioButton8_4, R.id.enradioButton10_4, R.id.enradioButton3_1, R.id.enradioButton4_1, R.id.enradioButton9_1 -> 1
            else -> 0 // 선택된 라디오 버튼이 없을 경우
        }
    }

    // 액티비티가 소멸될 때 binding을 null로 설정하여 메모리 누수 방지
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}