package com.bitc.project1.mbti

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bitc.project1.FortuneMainActivity
import com.bitc.project1.R
import com.bitc.project1.databinding.ActivityQuizBinding
import com.bitc.project1.mbti.en.MbtiENActivity
import com.bitc.project1.mbti.es.MbtiESActivity
import com.bitc.project1.mbti.`in`.MbtiINActivity
import com.bitc.project1.mbti.`is`.MbtiISActivity


class QuizActivity : AppCompatActivity() {

    private var binding: ActivityQuizBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // binding 초기화
        binding = ActivityQuizBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)

        binding!!.backButton.setOnClickListener {
            val intent = Intent(this, MbtiMainActivity::class.java)
            startActivity(intent)
        }

        binding!!.submitButton.setOnClickListener {
            if (isAnyRadioButtonSelected()) {
                val score = calculateScore()
                val snscore = calculateSNScore()

                if (score > 12 && snscore > 12) {
                    startActivity(Intent(this, MbtiENActivity::class.java))
                } else if (score > 12 && snscore <= 12) {
                    startActivity(Intent(this, MbtiESActivity::class.java))
                } else if (score <= 12 && snscore > 12) {
                    startActivity(Intent(this, MbtiINActivity::class.java))
                } else {
                    startActivity(Intent(this, MbtiISActivity::class.java))
                }
            } else {
                Toast.makeText(this, "선택되지 않은 문항이 있습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isAnyRadioButtonSelected(): Boolean {
        // 선택 여부를 확인하고 하나라도 선택되어 있으면 true를 반환
        return binding!!.radioGroup1.checkedRadioButtonId != -1 &&
                binding!!.radioGroup2.checkedRadioButtonId != -1 &&
                binding!!.radioGroup3.checkedRadioButtonId != -1 &&
                binding!!.radioGroup4.checkedRadioButtonId != -1 &&
                binding!!.radioGroup5.checkedRadioButtonId != -1 &&
                binding!!.radioGroup6.checkedRadioButtonId != -1 &&
                binding!!.radioGroup7.checkedRadioButtonId != -1 &&
                binding!!.radioGroup8.checkedRadioButtonId != -1 &&
                binding!!.radioGroup9.checkedRadioButtonId != -1 &&
                binding!!.radioGroup10.checkedRadioButtonId != -1
    }

    private fun calculateSNScore(): Int {
        var snscore = 0
        snscore += getScoreFromRadioButton(binding!!.radioGroup2)
        snscore += getScoreFromRadioButton(binding!!.radioGroup3)
        snscore += getScoreFromRadioButton(binding!!.radioGroup5)
        snscore += getScoreFromRadioButton(binding!!.radioGroup8)
        snscore += getScoreFromRadioButton(binding!!.radioGroup9)

        return snscore
    }

    private fun calculateScore(): Int {
        var score = 0

        score += getScoreFromRadioButton(binding!!.radioGroup1)
        score += getScoreFromRadioButton(binding!!.radioGroup4)
        score += getScoreFromRadioButton(binding!!.radioGroup6)
        score += getScoreFromRadioButton(binding!!.radioGroup7)
        score += getScoreFromRadioButton(binding!!.radioGroup10)

        return score
    }

    private fun getScoreFromRadioButton(radioGroup: RadioGroup): Int {
        val selectedRadioButtonId = radioGroup.checkedRadioButtonId
        return when (selectedRadioButtonId) {
            R.id.radioButton1_1, R.id.radioButton2_1, R.id.radioButton3_1, R.id.radioButton6_1, R.id.radioButton8_1, R.id.radioButton9_1, R.id.radioButton10_1, R.id.radioButton4_4, R.id.radioButton5_4, R.id.radioButton7_4 -> 4

            R.id.radioButton1_2, R.id.radioButton2_2, R.id.radioButton3_2, R.id.radioButton6_2, R.id.radioButton8_2, R.id.radioButton9_2, R.id.radioButton10_2, R.id.radioButton4_3, R.id.radioButton5_3, R.id.radioButton7_3 -> 3

            R.id.radioButton1_3, R.id.radioButton2_3, R.id.radioButton3_3, R.id.radioButton6_3, R.id.radioButton8_3, R.id.radioButton9_3, R.id.radioButton10_3, R.id.radioButton4_2, R.id.radioButton5_2, R.id.radioButton7_2 -> 2

            R.id.radioButton1_4, R.id.radioButton2_4, R.id.radioButton3_4, R.id.radioButton6_4, R.id.radioButton8_4, R.id.radioButton9_4, R.id.radioButton10_4, R.id.radioButton4_1, R.id.radioButton5_1, R.id.radioButton7_1 -> 1
            else -> 0 // 선택된 라디오 버튼이 없을 경우
        }
    }

    // 액티비티가 소멸될 때 binding을 null로 설정하여 메모리 누수 방지
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}