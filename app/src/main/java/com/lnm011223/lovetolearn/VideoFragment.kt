package com.lnm011223.lovetolearn


import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.fragment.app.Fragment
import com.lnm011223.lovetolearn.databinding.FragmentVideoBinding


class VideoFragment : Fragment() {

    private lateinit var binding: FragmentVideoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_image)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVideoBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.videoView.setVideoPath("http://116.205.143.169/zhrd/Primaryschool/Math/4th_grade/1.四年级上册第一周专题视频+练习视频/2.四年级上册第一周第一单元大数的认识专题2比较大小亿以内数的改写按要求组数")
        binding.videoView.start()
        val mediaController = MediaController(context)
        binding.videoView.setMediaController(mediaController)
        mediaController.setMediaPlayer(binding.videoView)

        var isPlay = false
        binding.floatingActionButton.setOnClickListener {
            if (!isPlay) {
                isPlay = true

                binding.floatingActionButton.apply {
                    hide()
                    setImageResource(R.drawable.ic_baseline_pause_24)
                    show()
                }
            } else {
                isPlay = false
                binding.floatingActionButton.apply {
                    hide()
                    setImageResource(R.drawable.ic_baseline_play_arrow_24)
                    show()
                }
            }
        }
    }


}