package com.lnm011223.lovetolearn

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.lnm011223.lovetolearn.databinding.FragmentWeekChallengeBinding


class weekChallengeFragment : Fragment() {
    private lateinit var binding: FragmentWeekChallengeBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var challengeList: ArrayList<challenge>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_image)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeekChallengeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        initChallenge()
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
        val adapter = ChallengeAdapter(challengeList)
        binding.weekChallengeRecyclerView.layoutManager = layoutManager
        binding.weekChallengeRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : ItemListenter {
            override fun bookClick(position: Int) {
                mainViewModel.challenge = challengeList[position]
                Toast.makeText(
                    context,
                    "${mainViewModel.challenge.challengeName}",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
        )
        adapter.setOnItemSelected(object : ItemSharedR{
            override fun onItemSelected(view: View) {
                view.transitionName = "challenge"
                val extras = FragmentNavigatorExtras(view to "challenge")
                Navigation.findNavController(view).navigate(R.id.action_weekChallengeFragment_to_challengeFragment,null,null,extras)
            }

        })
    }

    private fun initChallenge() {
        challengeList = arrayListOf()
        for (num in 1..20) {
            if (num%2 == 0){
                challengeList.add(challenge("第${num}周",0))
            }else{
                challengeList.add(challenge("第${num}周",1))
            }
        }
    }
}