package com.bitc.project1.mental

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bitc.project1.CookieActivity
import com.bitc.project1.MainActivity
import com.bitc.project1.R
import com.bitc.project1.card.TaroActivity
import com.bitc.project1.databinding.FragmentTest4ResultBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Test4ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Test4ResultFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    private lateinit var binding: FragmentTest4ResultBinding
    private lateinit var bottomNavi: BottomNavigationView

    var option = -1


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
        // 엘비스연산자??래
        option = arguments?.getInt("index")?:-1
        binding = FragmentTest4ResultBinding.inflate(inflater, container, false)
        bottomNavi = binding.bottomNavi
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        binding.btnBackToStart.setOnClickListener(this)

        binding.backtoSimList.setOnClickListener(this)

        setResult(option)

        bottomNavi.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.bottom1 -> {
                    startActivity(Intent(requireContext(), TaroActivity::class.java))
                    true
                }
                R.id.bottom2 -> {
                    startActivity(Intent(requireContext(), MainActivity::class.java))
                    true
                }
                R.id.bottom3 -> {
                    startActivity(Intent(requireContext(), CookieActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }

    fun setResult(option: Int) {
        when (option){
            1-> {
                binding.ivType.setImageResource(R.drawable.letter_a) // 옵션 1에 해당하는 이미지 리소스로 변경
                binding.tvContents.text ="당신은 무척 쾌활하며, 사교성이 뛰어나서 누구에게나 사랑받는 인기인입니다.\n" +
                        "\\n하지만 나서서 참견하는 경향이 있는데요 적극적인 성격을 가진덕에 모든일에 리더 역할을 자처하지만,\n" +
                        "사소한 일에 끼어들어 쓸데없는 참견을 하는 경우도 있습니다.\n" +
                        "\\n주변 사람들에게 성가진 존재가 되지 않도록 그 부분만 주의하세요"
            }
            2-> {
                binding.ivType.setImageResource(R.drawable.letter_b)
                binding.tvContents.text ="당신은 한마디로 기분파입니다.\n\n" +
                        "기분이 좋을 땐 누구에게나 밝게 행동하지만, 안 좋은 일이 생겼을 땐 입을 꾹 다물고 뾰로통해 있기도 합니다.\n\n" +
                        "하지만 이런 솔직한 성격의 당신을 잘 아는 사람이라면 당신을 좋아할 수 밖에 없습니다.\n\n" +
                        "자신에게 솔직하고 강한 개성을 지닌 당신은, 손해 보는 성격은 결코 아닐 듯 합니다.\n" }
            3-> {
                binding.ivType.setImageResource(R.drawable.letter_c)
                binding.tvContents.text ="냉철하고 신중한 현실파입니다.\n\n" +
                        "로맨틱한 사랑보다는 실제의 생활을 중요시하는 타입입니다. 돌다리도 두드려 보아야 할 만큼 경계심이 강해서" +
                        "달콤한 사탕발림에 넘어가는 일이 좀처럼 없습니다.\n\n" +
                        "연애에 있어서도 마찬가지입니다. 막상 눈 앞에 이성이 나타나면 지나치게 신중함을 보여 딱딱한 인상을 남길 수도 있습니다.\n\n" +
                        "편안하고 부드러운 인간미에 신경 쓰는 것이 좋을 것 같네요\n" }
            4-> {
                binding.ivType.setImageResource(R.drawable.letter_d)
                binding.tvContents.text ="언뜻 보기에 차가운 인상을 줍니다.\n\n" +
                        "실제로는 부드러운 사람이지만 강하고 차가운 이미지로 오해받기 쉽습니다.\n\n" +
                        "이런 이미지 때문에 당신을 마음에 두고 있던 이성이 접근을 피한 경우도 많았을 겁니다.\n\n" +
                        "당신은 사실 외로움을 잘 타는 타입인데 말이죠.\n"
            }
            5-> {
                binding.ivType.setImageResource(R.drawable.letter_e)
                binding.tvContents.text ="부끄러움을 잘 타는 당신은 자신의 마음을 표현하는 것에 몹시 서툽니다.\n\n" +
                        "이런 성격 탓에 사귀기 어려운 상대로 오해받고 있지는 않으신가요?\n\n" +
                        "게다가 소극적이고 자신의 주장을 잘 펼치지 못해 친구와의 교제에서 손해를 보는 일도 적지 않았을겁니다.\n\n" +
                        "마음에 드는 이성을 친구에게 빼앗기는 비극이 일어지 않게 주의하세요!\n"
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnBackToStart -> {
                // 이동할 대상 fragment의 ID를 사용하여 navigate를 호출
                navController.navigate(R.id.action_test4ResultFragment_to_quest1Fragment)
            }
            R.id.backtoSimList -> {
                Log.d("Test4ResultFragment", "backtoSimList clicked")
                val intent = Intent(requireContext(), SimActivity::class.java)
                startActivity(intent)
            }
        }
    }
}