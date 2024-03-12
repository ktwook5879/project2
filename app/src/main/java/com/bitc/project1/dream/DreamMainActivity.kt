package com.bitc.project1.dream

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bitc.project1.R
import com.bitc.project1.databinding.ActivityDreamMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class DreamMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDreamMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDreamMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragments = listOf(
            ToiletFragment(),
            AnimalFragment(),
            ActiveFragment(),
            GhostFragment(),
            BodyFragment()
        )

        // ViewPager2 어댑터 설정
        binding.viewPager.adapter = ViewPagerAdapter(this, fragments)

        // TabLayout과 ViewPager2를 연결
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "화장실"
                1 -> "동물"
                2 -> "행동"
                3 -> "귀신"
                4 -> "신체"
                else -> "Unknown"
            }
        }.attach()
    }

    private inner class ViewPagerAdapter(
        activity: AppCompatActivity,
        private val fragments: List<Fragment>
    ) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int = fragments.size
        override fun createFragment(position: Int): Fragment = fragments[position]
    }
}
