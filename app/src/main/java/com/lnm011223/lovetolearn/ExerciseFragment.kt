package com.lnm011223.lovetolearn

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.lnm011223.lovetolearn.databinding.FragmentExerciseBinding


class ExerciseFragment : Fragment() {
    private lateinit var binding: FragmentExerciseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_image)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExerciseBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val test = "6. 在括号里填上适当的数。（6分）\n" +
                "10.2平方千米=(　 　)公顷        \n" +
                "6.05kg=(    )kg(    )g　　\n" +
                "6吨40千克=(   　)吨             \n" +
                "12.5平方米=(     )平方米(     )平方分米\n"
        val test1 = TextView(context)
        test1.text = test
        binding.flexView.addView(test1)


    }


}