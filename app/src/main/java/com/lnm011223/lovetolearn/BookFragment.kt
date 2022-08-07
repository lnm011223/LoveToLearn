package com.lnm011223.lovetolearn

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.lnm011223.lovetolearn.databinding.FragmentBookBinding


class BookFragment : Fragment() {
    private lateinit var binding: FragmentBookBinding
    private val bookList =
        arrayListOf<String>("三年级上册", "三年级下册", "四年级上册", "四年级下册", "五年级上册", "五年级下册", "六年级上册", "六年级下册")
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
        binding = FragmentBookBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val adapter = BookAdapter(bookList,mainViewModel.isChallenge)
        binding.bookRecyclerView.layoutManager = layoutManager
        binding.bookRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : ItemListenter {
            override fun bookClick(position: Int) {
                mainViewModel.book = bookList[position]
                Toast.makeText(
                    context,
                    "${mainViewModel.book} ${mainViewModel.subject} ${mainViewModel.account}",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
        )
        adapter.setOnItemSelected(object : ItemShared {
            override fun onItemSelected(cardView: CardView, isChallenge: Int) {
                cardView.transitionName = "week"
                val extras = FragmentNavigatorExtras(cardView to "week")
                if (isChallenge == 0) {
                    Navigation.findNavController(cardView).navigate(R.id.action_bookFragment_to_weekFragment,null,null,extras)
                } else {
                    Navigation.findNavController(cardView)
                        .navigate(R.id.action_bookFragment_to_weekChallengeFragment,null,null,extras)
                }
            }
        })


    }


}