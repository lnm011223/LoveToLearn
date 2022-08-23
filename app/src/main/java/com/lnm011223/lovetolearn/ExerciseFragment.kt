package com.lnm011223.lovetolearn

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.bumptech.glide.Glide
import com.lnm011223.lovetolearn.databinding.FragmentExerciseBinding


class ExerciseFragment : Fragment() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: FragmentExerciseBinding
    private var titleList = arrayListOf<Title>()
    private var flag1 = 0
    var editList = ArrayList<EditText>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_image)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExerciseBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        getCountDownTime()
        initTitleList()

        binding.allNumText.text = titleList.size.toString()

        Glide.with(this)
            .load("http://116.205.143.169/zhrd/3")
            .into(binding.titleImg)

        //用竖直方向LinearLayout当底，每一行用一个横向的LinearLayout addView内容

        val test = titleList[0].title
        val yes = titleSplit(test)
        editList.clear()


        for (i in yes) {
            val linearLayout = LinearLayout(context)
            var flag = 0
            for (j in i) {
                flag++
                val textView = TextView(context)
                textView.text = j
                linearLayout.addView(textView)
                if (flag != i.size) {
                    val editText = EditText(context)
                    editList.add(editText)
                    linearLayout.addView(editText)
                }
            }

            binding.titleBg.addView(linearLayout)
        }
        getAnswers()
        binding.completeButton.setOnClickListener {
//            var result = ""
//            var flag = 0
//            for (i in editList) {
//                flag++
//                if (flag != editList.size) {
//                    result += "${i.text},"
//                } else {
//                    result += "${i.text}"
//                }
//            }
            timer?.cancel()
            val bundle = Bundle()
            bundle.putParcelableArrayList("resultList",titleList)
            val extras = FragmentNavigatorExtras(it to "result")
            Navigation.findNavController(it)
                .navigate(R.id.action_exerciseFragment_to_resultFragment, bundle, null, extras)
        }
        binding.lastButton.setOnClickListener {
            Toast.makeText(context, flag1.toString(), Toast.LENGTH_SHORT).show()
            if (flag1 >= 1) {
                flag1--
                binding.titleBg.removeAllViews()

                Glide.with(this)
                    .load(titleList[flag1].imgUrl)
                    .into(binding.titleImg)

                //用竖直方向LinearLayout当底，每一行用一个横向的LinearLayout addView内容

                val test = titleList[flag1].title
                val yes = titleSplit(test)

                editList.clear()

                for (i in yes) {
                    val linearLayout = LinearLayout(context)
                    var flag = 0
                    for (j in i) {
                        flag++
                        val textView = TextView(context)
                        textView.text = j
                        linearLayout.addView(textView)
                        if (flag != i.size) {
                            val editText = EditText(context)
                            editList.add(editText)
                            linearLayout.addView(editText)
                        }
                    }

                    binding.titleBg.addView(linearLayout)
                }
                binding.nowNumText.text = (flag1 + 1).toString()
            }
            getAnswers()
        }
        binding.nextButton.setOnClickListener {

            Toast.makeText(context, flag1.toString(), Toast.LENGTH_SHORT).show()
            if (flag1 < titleList.size - 1) {
                flag1++
                binding.titleBg.removeAllViews()

                Glide.with(this)
                    .load(titleList[flag1].imgUrl)
                    .into(binding.titleImg)

                //用竖直方向LinearLayout当底，每一行用一个横向的LinearLayout addView内容

                val test = titleList[flag1].title
                val yes = titleSplit(test)

                editList.clear()

                for (i in yes) {
                    val linearLayout = LinearLayout(context)
                    var flag = 0
                    for (j in i) {
                        flag++
                        val textView = TextView(context)
                        textView.text = j
                        linearLayout.addView(textView)
                        if (flag != i.size) {
                            val editText = EditText(context)
                            editList.add(editText)
                            linearLayout.addView(editText)
                        }
                    }

                    binding.titleBg.addView(linearLayout)
                }
                binding.nowNumText.text = (flag1 + 1).toString()
            }
            getAnswers()
        }


    }

    private fun getAnswers(){
        var realResult = ""
        for (i in editList) {
            i.addTextChangedListener {
                var result = ""
                var flag = 0
                for (i in editList) {
                    flag++
                    if (flag != editList.size) {
                        result += "${i.text},"
                    } else {
                        result += "${i.text}"
                    }
                }
//                Toast.makeText(context, result, Toast.LENGTH_SHORT).show()
                if (result == titleList[flag1].answer) {
                    titleList[flag1].isRight = 1
                }else{
                    titleList[flag1].isRight = 0
                }
                //Toast.makeText(context, "${titleList[flag1].isRight}", Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun initTitleList() {
        titleList.clear()
        titleList.add(
            Title(
                "31. （填空）某小学四年级各班参加植树活动的人数如下图，endl根据图中信息填空。（6分）endl" +
                        "（1）参加人数最多的是四（input）班，最少的是四（input）班。endl" +
                        "（2）一共有（input）人参加植树，其中男生（input）人，女生（input）人。endl" +
                        "（3）已知一共栽了339棵树，平均每人栽（input）棵。endl",
                "1,2,3,4,5,6",
                0,
                "http://116.205.143.169/zhrd/3",
                4
            )
        )
        titleList.add(
            Title(
                "29. （填空）电影院的电影票分甲等和乙等两种，甲等票每张售30元，乙等票每张endl" +
                        "售20元，学校买回14张电影票共用了360元。学校买了甲等票(input)张和乙等endl" +
                        "票(input)张。（4分)",
                "1,2",
                0,
                "",
                4
            )
        )
        titleList.add(
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

    private fun titleSplit(text: String): ArrayList<List<String>> {

        val chaifen = "endl"
        val text1 = text.split(chaifen) as ArrayList<String>
        val complete: ArrayList<List<String>> = arrayListOf()
        println(text1)
        for (text2 in text1) {
            val test3 = text2.split("input")
            complete.add(test3)
            println(test3)
        }

        return complete
    }

    private var timer: CountDownTimer? = null
    private fun getCountDownTime() {
        var timeStemp = 63 * 1000
        timer = object : CountDownTimer(timeStemp!!.toLong(), 1000) {

            override fun onTick(l: Long) {
                //val day = l / (1000 * 24 * 60 * 60) //单位天
                //val hour = (l - day * (1000 * 24 * 60 * 60)) / (1000 * 60 * 60) //单位时
                //val minute =
                //    (l - day * (1000 * 24 * 60 * 60) - hour * (1000 * 60 * 60)) / (1000 * 60) //单位分
                //val second =
                //    (l - day * (1000 * 24 * 60 * 60) - hour * (1000 * 60 * 60) - minute * (1000 * 60)) / 1000 //单位秒

                val minute = l / (60 * 1000)
                val second = (l - minute * (60 * 1000)) / 1000

                timeStemp = l.toInt()
                binding.timeText.text =
                    "${String.format("%02d", minute)}:${String.format("%02d", second)}"
                //Toast.makeText(context,"${String.format("%02d", minute)}:${String.format("%02d", second)}",Toast.LENGTH_SHORT).show()

            }

            override fun onFinish() {
                binding.timeText.text = "时间结束！"
                binding.timeText.setTextColor(Color.parseColor("#DF2935"))
                //倒计时为0时执行此方法
                Toast.makeText(context, "时间结束！", Toast.LENGTH_SHORT).show()

            }
        }
        (timer as CountDownTimer).start()
    }

    override fun onDestroy() {
        super.onDestroy()

        timer?.cancel()
    }

}


//val test1 = "6. 在括号里填上适当的数。（6分）\n" +
//        "10.2平方千米=（　　）公顷        \n" +
//        "6.05kg=（　　）kg（　　）g　　\n" +
//        "6吨40千克=(     )吨             \n" +
//        "12.5平方米=(     )平方米(     )平方分米\n6. 在括号里填上适当的数。（6分）\n" +
//        "10.2平方千米=(     )公顷        \n" +
//        "6.05kg=(     )kg(     )g　　\n" +
//        "6吨40千克=(     )吨             \n" +
//        "12.5平方米=(     )平方米(     )平方分米\n"
//val test = "1.$test1"
//val chaifeng = "（　　）"
//val parts = test.split(chaifeng)
//val num = parts.size
//var editTextlist = ArrayList<EditText>()
//var textViewlist = ArrayList<TextView>()
//
//var kuohaonum = 0
//
////var autoLineLayout = AntoLineUtil(MyApplication.context)
//
////test_linear.addView(autoLineLayout)
//var flag = false
//for (i in 0..num-1) {
//    if (i!=num-1) {
//        if (i == 0) {
//            flag = true
//        }else{
//            flag = false
//        }
//        var text_test = TextView(MyApplication.context)
//        var lefttext = TextView(MyApplication.context)
//        var righttext = TextView(MyApplication.context)
//        var edit_test = EditText(MyApplication.context)
//        lefttext.text = "("
//        righttext.text = ")"
//        textViewlist.add(text_test)
//        editTextlist.add(edit_test)
//        if (flag) {
//            textViewlist[i].text = "${parts[i]}"
//        }else{
//            textViewlist[i].text = "${parts[i]}"
//        }
//
//        editTextlist[i].apply {
//            isCursorVisible = false
//            hint = "____"
//            //minWidth = 30
//            background = null
//            setPadding(0,0,0,0)
//            minHeight = text_test.height
//            textSize = 14f}
//        flex.apply {
//            addView(textViewlist[i])
//            addView(lefttext)
//            addView(editTextlist[i])
//            addView(righttext)
//        }
//
//    }else{
//        var text_test = TextView(MyApplication.context)
//        textViewlist.add(text_test)
//        textViewlist[i].text = "${parts[i]}"
//        flex.apply {
//            addView(textViewlist[i])
//
//        }
//    }
//}
//val ringtanswer = "减,乘,除"
//var answer = ""
//for (i in editTextlist){
//    i.addTextChangedListener {
//        answer = ""
//        var x = 0
//        for (j in editTextlist) {
//            if (x == 0){
//                answer += "${j.text}"
//                x = 1
//            }else{
//                answer += ",${j.text}"
//            }
//
//
//        }
//        if (answer == ringtanswer) {
//            Toast.makeText(context, "回答正确", Toast.LENGTH_SHORT).show()
//            for (a in textViewlist) {
//
//                a.setTextColor(ContextCompat.getColorStateList(MyApplication.context,R.color.blue))
//            }
//
//        }
//    }
//}