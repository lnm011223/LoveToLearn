package com.lnm011223.lovetolearn

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**

 * @Author liangnuoming
 * @Date 2022/8/6-4:32 下午

 */
class Topic(val topicName: String, val topicType: Int, val videoUrl: String) {
    companion object {
        const val TYPE_EXERCISE = 0
        const val TYPE_VIDEO = 1
    }
}

class Challenge(val challengeName: String, val isDone: Int)

class Scholarship(
    val achievement: String,
    val scholarship1: String,
    val keep: String,
    val scholarship2: String,
    val synthesis: String,
    val scholarship3: String
)

@Parcelize
class Title(
    val title: String,
    val answer: String,
    var isRight: Int,
    val imgUrl: String,
    val score: Int
) : Parcelable

class MoreTitle(
    val title: String,
    val answer: String,
    val isRight: Int,
    val imgUrl: String,
    val score: Int,
    val videoUrl: String
)


fun main() {


}


fun getAnswerErrorItem(array1: ArrayList<String>, array2: ArrayList<String>): ArrayList<Int> {
    val array3 = arrayListOf<Int>()
    for (i in 0 until array1.size) {
        if (array1[i] != array2[i]) {
            array3.add(i)
        }
    }
    return array3
}