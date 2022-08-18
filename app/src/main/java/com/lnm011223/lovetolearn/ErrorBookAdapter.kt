package com.lnm011223.lovetolearn

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView


/**

 * @Author liangnuoming
 * @Date 2022/8/10-10:55 下午

 */
class ErrorBookAdapter(val errorList: ArrayList<MoreTitle>, val context: Context) :
    RecyclerView.Adapter<ErrorBookAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleErrorImg: ImageView = view.findViewById(R.id.titleErrorImg)
//        val errorBg: LinearLayout = view.findViewById(R.id.errorBg)
        val errorCard: MaterialCardView = view.findViewById(R.id.errorCard)
        val errorText: TextView = view.findViewById(R.id.errorText)
        val answerInput: EditText = view.findViewById(R.id.answerInput)
        val showBtn: Button = view.findViewById(R.id.showBtn)
        val videoBtn: Button = view.findViewById(R.id.videoBtn)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.errorbook_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.showBtn.setOnClickListener {
            val position = viewHolder.adapterPosition
            viewHolder.answerInput.setText(errorList[position].answer.toString())

        }
        viewHolder.videoBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_errorBookFragment_to_videoFragment)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val error = errorList[position]
        holder.errorText.text = error.title

        Glide.with(context).load(error.imgUrl).into(holder.titleErrorImg)


    }

    override fun getItemCount() = errorList.size


}