package com.lnm011223.lovetolearn

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.lnm011223.lovetolearn.databinding.FragmentTopicBinding


class TopicFragment : Fragment() {
    private lateinit var binding: FragmentTopicBinding
    private lateinit var mainViewModel: MainViewModel
    private val topicList = ArrayList<topic>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_image)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopicBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        initTopic()
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val adapter = TopicAdapter(topicList)
        binding.topicRecyclerView.layoutManager = layoutManager
        binding.topicRecyclerView.adapter = adapter
    }

    private fun initTopic() {
        topicList.add(topic("专题1 分数乘整数",topic.TYPE_VIDEO,""))
        topicList.add(topic("专题1 分数乘整数 跟踪练习",topic.TYPE_EXERCISE,""))
        topicList.add(topic("专题1 一个数数乘整数",topic.TYPE_VIDEO,""))
        topicList.add(topic("专题1 一个数数乘整数 跟踪练习",topic.TYPE_EXERCISE,""))
    }


}