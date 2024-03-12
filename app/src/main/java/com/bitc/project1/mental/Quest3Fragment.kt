package com.bitc.project1.mental

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bitc.project1.R
import com.bitc.project1.databinding.FragmentQuest3Binding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Quest3Fragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    private lateinit var binding: FragmentQuest3Binding

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuest3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        binding.btnDirectTake.setOnClickListener(this)
        binding.btnDoubleRing.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnDirectTake -> {
                navController.navigate(R.id.action_quest3Fragment_to_quest5Fragment)
            }
            R.id.btnDoubleRing -> {
                navController.navigate(R.id.action_quest3Fragment_to_quest7Fragment)
            }
        }
    }
}