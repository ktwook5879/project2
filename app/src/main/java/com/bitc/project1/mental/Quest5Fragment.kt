package com.bitc.project1.mental

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bitc.project1.R
import com.bitc.project1.databinding.FragmentQuest5Binding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Quest5Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Quest5Fragment : Fragment() ,View.OnClickListener{

    lateinit var navController: NavController
    private lateinit var binding: FragmentQuest5Binding

    // TODO: Rename and change types of parameters
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
        binding = FragmentQuest5Binding.inflate(inflater, container, false) // YourBindingType으로 바인딩 객체 초기화
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Quest5Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Quest5Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        binding.btnSocks.setOnClickListener(this)
        binding.btnChoco.setOnClickListener(this)

    }
        override fun onClick(v: View?) {
            when (v?.id) {
                R.id.btnSocks -> {
                    navController.navigate(R.id.action_quest5Fragment_to_quest4Fragment)
                }
                R.id.btnChoco -> {
                    navController.navigate(R.id.action_quest5Fragment_to_quest6Fragment)
                }
            }
        }
    }
