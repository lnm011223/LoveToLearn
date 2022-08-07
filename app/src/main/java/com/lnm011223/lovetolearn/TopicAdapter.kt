package com.lnm011223.lovetolearn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**

 * @Author liangnuoming
 * @Date 2022/8/6-4:30 下午

 */
class TopicAdapter(val topicList: ArrayList<topic>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ExerciseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val exerciseName: TextView = view.findViewById(R.id.topicExerciseName)
    }

    inner class VideoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val videoName: TextView = view.findViewById(R.id.topicVideoName)
    }

    override fun getItemViewType(position: Int): Int {
        val topic = topicList[position]
        return topic.topicType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        if (viewType == topic.TYPE_EXERCISE) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.topic_exercise_item, parent, false)
            ExerciseViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.topic_video_item, parent, false)
            VideoViewHolder(view)
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val topic = topicList[position]
        when(holder) {
            is ExerciseViewHolder -> holder.exerciseName.text = topic.topicName
            is VideoViewHolder -> holder.videoName.text = topic.topicName
            else -> throw IllegalAccessException()
        }
    }

    override fun getItemCount() = topicList.size


}