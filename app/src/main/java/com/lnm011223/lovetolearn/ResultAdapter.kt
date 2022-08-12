package com.lnm011223.lovetolearn

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView



/**

 * @Author liangnuoming
 * @Date 2022/8/10-10:55 下午

 */
class ResultAdapter(val resultList: ArrayList<Title>,val context: Context) :
    RecyclerView.Adapter<ResultAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleImg: ImageView = view.findViewById(R.id.titleResultImg)
        val resultBg: LinearLayout = view.findViewById(R.id.resultBg)
        val resultCard: MaterialCardView = view.findViewById(R.id.resultCard)
        val resultText: TextView = view.findViewById(R.id.resultText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.result_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition


        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = resultList[position]
        if (result.isRight == 1) {
            holder.resultCard.strokeColor = Color.parseColor("#329F5B".toString())
        }
        val yes = titleSplit(result.title)
        val answer = result.answer.split(",")
        var ddd = ""
        var answerFlag = 0
        for (i in yes) {
            var flag = 0

            for (j in i) {
                flag++
                ddd += j
                if (flag != i.size && answerFlag != answer.size) {

                    ddd += answer[answerFlag]
                    answerFlag++
                }
            }
            ddd += "\n"
        }
        holder.resultText.text = ddd
        Glide.with(context).load(result.imgUrl).into(holder.titleImg)


    }

    override fun getItemCount() = resultList.size

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