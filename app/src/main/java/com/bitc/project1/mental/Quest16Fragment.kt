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
import com.bitc.project1.databinding.FragmentQuest16Binding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Quest16Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Quest16Fragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    private lateinit var binding: FragmentQuest16Binding
    var option = -1


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
        option = arguments?.getInt("index")?:-1

        binding = FragmentQuest16Binding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        binding.btnShoes.setOnClickListener(this)
        binding.btnSneakers.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v?.id) {
//            A타입
            R.id.btnShoes -> {navigateWithIndex(1)}

//             B타입
            R.id.btnSneakers -> {navigateWithIndex(2)}
        }
    }

    fun navigateWithIndex(index : Int) {
        val bundle : Bundle = bundleOf("index" to index)

        navController.navigate(R.id.action_quest16Fragment_to_test4ResultFragment,bundle)
    }
}