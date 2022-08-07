package com.lnm011223.lovetolearn

import android.view.View
import androidx.cardview.widget.CardView

/**

 * @Author liangnuoming
 * @Date 2022/8/1-4:29 下午

 */
interface ItemListenter {
    fun bookClick(position: Int)
}

interface ItemShared {
    fun onItemSelected(cardView: CardView,isChallenge: Int)
}

interface ItemSharedR {
    fun onItemSelected(view:View)
}