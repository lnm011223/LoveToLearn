package com.lnm011223.lovetolearn

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.lnm011223.lovetolearn.databinding.FragmentWeekBinding

class WeekFragment : Fragment() {
    private lateinit var binding: FragmentWeekBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var weeklist: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_image)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentWeekBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        weeklist = arrayListOf()
        for (num in 1..20) {
            weeklist.add("第${num}周")
        }
        val layoutManager = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
        val adapter = WeekAdapter(weeklist)
        binding.weekRecyclerView.layoutManager = layoutManager
        binding.weekRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : ItemListenter {
            override fun bookClick(position: Int) {
                mainViewModel.week = weeklist[position]
                Toast.makeText(
                    context,
                    "${mainViewModel.week} ${mainViewModel.book} ${mainViewModel.subject} ${mainViewModel.account}",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
        )
        adapter.setOnItemSelected(object : ItemSharedR{
            override fun onItemSelected(view: View) {
                view.transitionName = "Topic"
                val extras = FragmentNavigatorExtras(view to "Topic")
                Navigation.findNavController(view).navigate(R.id.action_weekFragment_to_topicFragment,null,null,extras)
            }

        })

    }



}