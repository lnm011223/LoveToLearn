package com.lnm011223.lovetolearn

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.lnm011223.lovetolearn.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: FragmentResultBinding
    private var resultList = arrayListOf<Title>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_image)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
//        initResult()
        resultList = arguments?.get("resultList") as ArrayList<Title>
        var score = 0

        for (i in resultList) {
            if (i.isRight == 1) {
                score += i.score
            }
        }
        binding.commentText.text = when (score) {
            in 96..100 -> "宝贝真棒! 继续保持，你是最棒的！"
            in 85..95 -> "宝贝很棒! 你很优秀，但是还是要加油哦，棒棒的！"
            in 75..84 -> "很好! 再接再厉，更进一步，加油！"
            in 60..74 -> "不错! 坚持学习，力争上游，加油！"
            else -> "下次要努力哦！争取更大的进步。"
        }
        binding.scoreText.text = "$score 分"
        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        val adapter = context?.let { ResultAdapter(resultList, it) }
        binding.resultRecyclerView.layoutManager = layoutManager
        binding.resultRecyclerView.adapter = adapter
    }

    private fun initResult() {
        resultList.add(
            Title(
                "31. （填空）某小学四年级各班参加植树活动的人数如下图，endl根据图中信息填空。（6分）endl" +
                        "（1）参加人数最多的是四（input）班，最少的是四（input）班。endl" +
                        "（2）一共有（input）人参加植树，其中男生（input）人，女生（input）人。endl" +
                        "（3）已知一共栽了339棵树，平均每人栽（input）棵。endl",
                "1,2,3,4,5,6",
                0,
                "http://116.205.143.169/zhrd/3",
                3
            )
        )
        resultList.add(
            Title(
                "29. （填空）电影院的电影票分甲等和乙等两种，甲等票每张售30元，乙等票每张endl" +
                        "售20元，学校买回14张电影票共用了360元。学校买了甲等票(input)张和乙等endl" +
                        "票(input)张。（4分)",
                "1,2",
                1,
                "",
                4
            )
        )
        resultList.add(
            Title(
                "27. （选择）妈妈带了100元去超市购物。她先买了36.5元的水果，又买了23.5元endl" +
                        "的生活用品，绿豆每千克12.8元，妈妈剩下的钱够买3千克的绿豆吗?（input）（3分）endl" +
                        "A  够                            B  不够",
                "A",
                0,
                "",
                3
            )
        )
    }


}