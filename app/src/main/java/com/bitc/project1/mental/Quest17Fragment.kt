package com.bitc.project1.mental

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bitc.project1.R
import com.bitc.project1.databinding.FragmentQuest17Binding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Quest17Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Quest17Fragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    private lateinit var binding: FragmentQuest17Binding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuest17Binding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        binding.btnYes.setOnClickListener(this)
        binding.btnNo.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnYes -> {
                navController.navigate(R.id.action_quest17Fragment_to_quest16Fragment)
            }

            R.id.btnNo -> {
                navController.navigate(R.id.action_quest17Fragment_to_quest18Fragment)
            }
        }
    }
}