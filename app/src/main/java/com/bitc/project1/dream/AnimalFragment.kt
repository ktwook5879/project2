package com.bitc.project1.dream

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bitc.project1.R


class AnimalFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_animal, container, false)

        // 스크롤뷰 생성
        val scrollView = ScrollView(requireContext())
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        scrollView.layoutParams = layoutParams

        // 세로 레이아웃 생성
        val linearLayout = LinearLayout(requireContext())
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.setPadding(
            resources.getDimensionPixelSize(R.dimen.linear_layout_padding),
            resources.getDimensionPixelSize(R.dimen.linear_layout_padding),
            resources.getDimensionPixelSize(R.dimen.linear_layout_padding),
            resources.getDimensionPixelSize(R.dimen.linear_layout_padding)
        )

        // Get the array of questions and answers
        val questions = resources.getStringArray(R.array.dreamAnimal_questions)
        val answers = resources.getStringArray(R.array.dreamAnimal_answers)

        // Loop through the arrays and dynamically create TextViews
        for (i in questions.indices) {
            // 질문 텍스트뷰 생성 및 추가
            val questionTextView = TextView(requireContext())
            questionTextView.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                resources.getDimensionPixelSize(R.dimen.question_text_height)
            )
            questionTextView.text = questions[i]
            linearLayout.addView(questionTextView)

            // 답변 텍스트뷰 생성 및 추가
            val answerTextView = TextView(requireContext())
            answerTextView.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            answerTextView.visibility = View.GONE // 초기에는 보이지 않음
            answerTextView.background = ContextCompat.getDrawable(requireContext(), R.color.gray)
            answerTextView.gravity = Gravity.CENTER
            answerTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            answerTextView.text = answers[i]
            linearLayout.addView(answerTextView)

            // 답변 텍스트뷰 바로 아래에 빈 공간 추가
            val spaceView = View(requireContext())
            val spaceLayoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                resources.getDimensionPixelSize(R.dimen.answer_text_space)
            )
            spaceView.layoutParams = spaceLayoutParams
            spaceView.visibility = View.GONE
            linearLayout.addView(spaceView)

            // 질문 텍스트뷰 클릭 시 답변 텍스트뷰 토글 및 공간 토글
            questionTextView.setOnClickListener {
                // Toggle answer visibility
                answerTextView.visibility = if (answerTextView.visibility == View.VISIBLE) View.GONE else View.VISIBLE
                // Toggle space visibility
                spaceView.visibility = if (answerTextView.visibility == View.VISIBLE) View.VISIBLE else View.GONE
            }
        }

        // 스크롤뷰에 세로 레이아웃 추가
        scrollView.addView(linearLayout)

        // 최종적으로 스크롤뷰를 프래그먼트 레이아웃에 추가
        return scrollView
    }
}
