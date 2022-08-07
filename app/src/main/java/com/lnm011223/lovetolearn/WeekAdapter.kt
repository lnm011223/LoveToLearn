package com.lnm011223.lovetolearn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

/**

 * @Author liangnuoming
 * @Date 2022/8/1-4:14 下午

 */
class WeekAdapter(val weeklist: ArrayList<String>) : RecyclerView.Adapter<WeekAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val weekName : TextView = view.findViewById(R.id.weekName)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.week_item,parent,false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            itemListenter?.bookClick(position)
            itemSharedR?.onItemSelected(it)
            //Navigation.findNavController(it).navigate(R.id.action_weekFragment_to_topicFragment)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val week = weeklist[position]
        holder.weekName.text = week.toString()

    }

    override fun getItemCount() = weeklist.size

    private var itemSharedR: ItemSharedR? = null
    private var itemListenter: ItemListenter? = null
    fun setOnItemClickListener(itemListenter: ItemListenter?) {
        this.itemListenter = itemListenter
    }
    fun setOnItemSelected(itemSharedR: ItemSharedR?) {
        this.itemSharedR = itemSharedR
    }
}