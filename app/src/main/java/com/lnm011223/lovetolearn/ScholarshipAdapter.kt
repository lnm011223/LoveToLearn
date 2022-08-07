package com.lnm011223.lovetolearn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**

 * @Author liangnuoming
 * @Date 2022/8/1-4:14 下午

 */
class ScholarshipAdapter(val sholarshiplist: ArrayList<scholarship>) :
    RecyclerView.Adapter<ScholarshipAdapter.ViewHolder>() {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val achievementText: TextView = view.findViewById(R.id.achievementText)
        val scholarshipText1: TextView = view.findViewById(R.id.scholarshipText1)
        val keepText: TextView = view.findViewById(R.id.keepText)
        val scholarshipText2: TextView = view.findViewById(R.id.scholarshipText2)
        val synthesisText: TextView = view.findViewById(R.id.synthesisText)
        val scholarshipText3: TextView = view.findViewById(R.id.scholarshipText3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.scholarship_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition


        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val scholarship = sholarshiplist[position]
        holder.apply {
            achievementText.text = scholarship.achievement
            scholarshipText1.text = scholarship.scholarship1
            keepText.text = scholarship.keep
            scholarshipText2.text = scholarship.scholarship2
            synthesisText.text = scholarship.synthesis
            scholarshipText3.text = scholarship.scholarship3
        }


    }

    override fun getItemCount() = sholarshiplist.size

}