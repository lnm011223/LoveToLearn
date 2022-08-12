package com.lnm011223.lovetolearn

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


class Title(val title:String, val answer:String, val isRight: Int,val imgUrl:String)