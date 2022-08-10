package com.lnm011223.lovetolearn

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.bumptech.glide.Glide
import com.lnm011223.lovetolearn.databinding.FragmentExerciseBinding


class ExerciseFragment : Fragment() {
    private lateinit var binding: FragmentExerciseBinding

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

            Glide.with(this)
                .load("http://116.205.143.169/zhrd/3")
                .into(binding.titleImg)

        //用竖直方向LinearLayout当底，每一行用一个横向的LinearLayout addView内容


//        val test = "6. 在括号里填上适当的数。（6分）\n" +
//                "10.2平方千米=(input)公顷        \n" +
//                "6.05kg=(input)kg(input)g　　\n" +
//                "6吨40千克=(input)吨             \n" +
//                "12.5平方米=(input)平方米(input)平方分米\n"
        val test = "31. （填空）某小学四年级各班参加植树活动的人数如下图，endl根据图中信息填空。（6分）endl" +
                "（1）参加人数最多的是四（input）班，最少的是四（input）班。endl" +
                "（2）一共有（input）人参加植树，其中男生（input）人，女生（input）人。endl" +
                "（3）已知一共栽了339棵树，平均每人栽（input）棵。endl"
        val yes = titleSplit(test)


        var editList = ArrayList<EditText>()
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
        binding.completeButton.setOnClickListener {
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
            Toast.makeText(context, result, Toast.LENGTH_SHORT).show()
            val extras = FragmentNavigatorExtras(it to "result")
            Navigation.findNavController(it).navigate(R.id.action_exerciseFragment_to_resultFragment,null,null,extras)
        }


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