package com.lnm011223.lovetolearn

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.lnm011223.lovetolearn.databinding.FragmentScholarshipBinding

class ScholarshipFragment : Fragment() {
    private lateinit var binding: FragmentScholarshipBinding
    private var scholarshipList = arrayListOf<Scholarship>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_image)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScholarshipBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initScholar()
        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        val adapter = ScholarshipAdapter(scholarshipList)
        binding.scholarshipRecyclerView.layoutManager = layoutManager
        binding.scholarshipRecyclerView.adapter = adapter
    }

    private fun initScholar() {
        scholarshipList.add(Scholarship("1","121.0","1","48.5","1","166.1"))
        scholarshipList.add(Scholarship("2","98.2","2","36.8","2","160.4"))
        scholarshipList.add(Scholarship("3","85.8","3","37.2","3","159.2"))
        scholarshipList.add(Scholarship("4","85.1","4","26.4","4","157.3"))
    }
}