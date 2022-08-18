package com.lnm011223.lovetolearn

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.lnm011223.lovetolearn.databinding.FragmentErrorBookBinding


class ErrorBookFragment : Fragment() {
    private lateinit var binding: FragmentErrorBookBinding
//    val dbHelper = MyDatabaseHelper(requireActivity(), "LoveToLearn.db", 1)
//    val db = dbHelper.writableDatabase
    private var errorList = arrayListOf<MoreTitle>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_image)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentErrorBookBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initErrorList()
        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        val adapter = context?.let { ErrorBookAdapter(errorList, it) }
        binding.errorRecyclerView.layoutManager = layoutManager
        binding.errorRecyclerView.adapter = adapter
    }

    private fun initErrorList() {
//        val cursor = db.query("ErrorBook", null, null, null, null, null, null)
//        if (cursor.moveToFirst()) {
//            do {
//
//            }while (cursor.moveToNext())
//
//        }
//        cursor.close()
        errorList.clear()
        errorList.add(
            MoreTitle("31. （填空）某小学四年级各班参加植树活动的人数如下图，endl根据图中信息填空。（6分）endl" +
                    "（1）参加人数最多的是四（input）班，最少的是四（input）班。endl" +
                    "（2）一共有（input）人参加植树，其中男生（input）人，女生（input）人。endl" +
                    "（3）已知一共栽了339棵树，平均每人栽（input）棵。endl",
                "1,2,3,4,5,6",
                0,
                "http://116.205.143.169/zhrd/3",
                4,
            "")
        )
        errorList.add(
            MoreTitle(
                "29. （填空）电影院的电影票分甲等和乙等两种，甲等票每张售30元，乙等票每张endl" +
                        "售20元，学校买回14张电影票共用了360元。学校买了甲等票(input)张和乙等endl" +
                        "票(input)张。（4分)",
                "1,2",
                0,
                "",
                4,
                ""
            )
        )
        errorList.add(
            MoreTitle(
                "27. （选择）妈妈带了100元去超市购物。她先买了36.5元的水果，又买了23.5元endl" +
                        "的生活用品，绿豆每千克12.8元，妈妈剩下的钱够买3千克的绿豆吗?（input）（3分）endl" +
                        "A  够                            B  不够",
                "A",
                0,
                "",
                3,
                ""
            )
        )
    }


}