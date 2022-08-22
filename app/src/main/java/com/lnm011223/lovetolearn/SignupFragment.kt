package com.lnm011223.lovetolearn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lnm011223.lovetolearn.databinding.FragmentSignupBinding

class SignupFragment : Fragment() {
    private lateinit var binding: FragmentSignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignupBinding.inflate(inflater,container,false)

        return binding.root
    }


}