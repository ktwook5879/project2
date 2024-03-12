package com.bitc.project1.mental

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bitc.project1.R
import com.bitc.project1.databinding.FragmentQuest1Binding


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Quest1Fragment : Fragment(), View.OnClickListener {
    private var param1: String? = null
    private var param2: String? = null

    lateinit var navController: NavController
    private lateinit var binding: FragmentQuest1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuest1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.btnEng.setOnClickListener(this)
        binding.btnMusic.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnEng -> {
                navController.navigate(R.id.action_quest1Fragment_to_quest2Fragment)
            }
            R.id.btnMusic -> {
                navController.navigate(R.id.action_quest1Fragment_to_quest4Fragment)
            }
        }
    }

}
