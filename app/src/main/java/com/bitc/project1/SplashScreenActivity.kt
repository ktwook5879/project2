package com.bitc.project1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var splashScreen: SplashScreen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 이 부분에서 스플래시 화면이 표시되고 필요한 초기화 작업을 수행할 수 있습니다.
        splashScreen = installSplashScreen()

        // 메인 액티비티로 전환
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // 스플래시 액티비티를 종료하여 사용자가 뒤로 가기 버튼을 눌렀을 때 다시 스플래시 화면이 나오지 않도록 합니다.
    }
}

