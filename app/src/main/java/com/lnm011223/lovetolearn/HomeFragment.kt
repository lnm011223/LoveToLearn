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
import com.lnm011223.lovetolearn.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_image)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        binding.liveAnswerButton.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_homeFragment_to_liveAnswerFragment)
        }
        binding.bookButton.setOnClickListener {
            mainViewModel.isChallenge = 0
            it.transitionName = "book"
            val extras = FragmentNavigatorExtras(it to "book")
            Navigation.findNavController(it)
                .navigate(R.id.action_homeFragment_to_bookFragment, null, null, extras)
        }
        binding.challengeButton.setOnClickListener {
            mainViewModel.isChallenge = 1
            it.transitionName = "book"
            val extras = FragmentNavigatorExtras(it to "book")
            Navigation.findNavController(it)
                .navigate(R.id.action_homeFragment_to_bookFragment, null, null, extras)
        }
        binding.scholarshipButton.setOnClickListener {
            val extras = FragmentNavigatorExtras(it to "scholarship")
            Navigation.findNavController(it)
                .navigate(R.id.action_homeFragment_to_scholarshipFragment,null,null,extras)
        }
    }


}