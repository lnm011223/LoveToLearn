package com.lnm011223.lovetolearn

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.lnm011223.lovetolearn.databinding.FragmentSubjectBinding


class SubjectFragment : Fragment() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: FragmentSubjectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_image)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSubjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        binding.mathButton.setOnClickListener {
            val extras = FragmentNavigatorExtras(binding.mathButton to "math")
            mainViewModel.subject = "math"
            Navigation.findNavController(it).navigate(R.id.action_subjectFragment_to_homeFragment,null,null,extras)
        }
        binding.chineseButton.setOnClickListener {
            val extras = FragmentNavigatorExtras(binding.chineseButton to "book")
            mainViewModel.subject = "chinese"
            Navigation.findNavController(it).navigate(R.id.action_subjectFragment_to_bookFragment,null,null,extras)
        }
    }
}