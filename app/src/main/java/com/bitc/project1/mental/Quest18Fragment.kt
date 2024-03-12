package com.bitc.project1.mental

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bitc.project1.R
import com.bitc.project1.databinding.FragmentQuest18Binding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Quest18Fragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    private lateinit var binding: FragmentQuest18Binding
    var option = -1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuest18Binding.inflate(inflater, container, false)
        option = arguments?.getInt("index")?:-1

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        binding.btnCat.setOnClickListener(this)
        binding.btnDog.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnDog -> {navigateWithIndex(3)}
            R.id.btnCat -> {navigateWithIndex(4)}

        }
    }

    private fun navigateWithIndex(index: Int) {
        val bundle : Bundle = bundleOf("index" to index)

        navController.navigate(R.id.action_quest18Fragment_to_test4ResultFragment,bundle)
    }

}