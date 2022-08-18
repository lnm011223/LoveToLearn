package com.lnm011223.lovetolearn

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.lnm011223.lovetolearn.databinding.FragmentChallengeBinding


class ChallengeFragment : Fragment() {
    private lateinit var binding: FragmentChallengeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_image)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChallengeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.errorBookButton.setOnClickListener {
            val extras = FragmentNavigatorExtras(it to "errorBook")
            Navigation.findNavController(it).navigate(R.id.action_challengeFragment_to_errorBookFragment,null,null,extras)
        }
        binding.onlyExerciseButton.setOnClickListener {
            val extras = FragmentNavigatorExtras(it to "exercise")
            Navigation.findNavController(it).navigate(R.id.action_challengeFragment_to_exerciseFragment,null,null,extras)
        }
    }


}