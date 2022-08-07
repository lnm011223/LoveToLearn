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
class BookAdapter(val booklist: ArrayList<String>, val isChallenge: Int) :
    RecyclerView.Adapter<BookAdapter.ViewHolder>() {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bookName: TextView = view.findViewById(R.id.bookName)
        val bookNameBg: CardView = view.findViewById(R.id.bookNameBg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            itemListenter?.bookClick(position)
            itemShared?.onItemSelected(viewHolder.bookNameBg,isChallenge)


        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = booklist[position]
        holder.bookName.text = book.toString()

    }

    override fun getItemCount() = booklist.size
    private var itemShared: ItemShared? = null
    private var itemListenter: ItemListenter? = null
    fun setOnItemClickListener(itemListenter: ItemListenter?) {
        this.itemListenter = itemListenter
    }
    fun setOnItemSelected(itemShared: ItemShared?) {
        this.itemShared = itemShared
    }
}