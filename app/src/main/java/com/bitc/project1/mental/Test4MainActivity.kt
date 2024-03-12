package com.bitc.project1.mental

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.bitc.project1.R
import com.bitc.project1.databinding.ActivityTest4MainBinding


class Test4MainActivity : AppCompatActivity() {

    lateinit var navController : NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTest4MainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // NavHostFragment를 찾아서 NavController 설정

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }
}