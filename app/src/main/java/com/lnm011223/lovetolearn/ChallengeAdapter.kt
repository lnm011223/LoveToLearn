package com.lnm011223.lovetolearn

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Color.red
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

/**

 * @Author liangnuoming
 * @Date 2022/8/1-4:14 下午

 */
class ChallengeAdapter(val challengelist: ArrayList<challenge>) :
    RecyclerView.Adapter<ChallengeAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val challengeName: TextView = view.findViewById(R.id.challengeName)
        val challengeIcon: ImageView = view.findViewById(R.id.challengeIcon)
        val challengeLine: CardView = view.findViewById(R.id.challengeLine)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.challenge_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            itemListenter?.bookClick(position)
            itemSharedR?.onItemSelected(it)
//            val bundle = Bundle()
//            bundle.putParcelable("challenge",challengelist[position])
            //Navigation.findNavController(it).navigate(R.id.action_weekChallengeFragment_to_challengeFragment)

        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val challenge = challengelist[position]
        holder.challengeName.text = challenge.challengeName.toString()
        if (challenge.isDone == 0){
            holder.challengeIcon.setImageResource(R.drawable.riawardline)
            holder.challengeLine.setBackgroundColor(Color.parseColor("#eeeeee"))
            holder.challengeIcon.imageTintList = ColorStateList.valueOf(Color.parseColor("#eeeeee"))
            //holder.challengeLine.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#eeeeee"))
        }else{
            holder.challengeIcon.setImageResource(R.drawable.riawardfill)
            holder.challengeLine.setBackgroundColor(Color.parseColor("#EA526F"))
            holder.challengeIcon.imageTintList = ColorStateList.valueOf(Color.parseColor("#EA526F"))
        }

    }

    override fun getItemCount() = challengelist.size

    private var itemSharedR: ItemSharedR? = null
    private var itemListenter: ItemListenter? = null
    fun setOnItemClickListener(itemListenter: ItemListenter?) {
        this.itemListenter = itemListenter
    }
    fun setOnItemSelected(itemSharedR: ItemSharedR?) {
        this.itemSharedR = itemSharedR
    }
}