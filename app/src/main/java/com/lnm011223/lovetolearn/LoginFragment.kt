package com.lnm011223.lovetolearn


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Paint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.lnm011223.lovetolearn.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    @SuppressLint("CommitPrefEdits")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val prefs = activity?.getSharedPreferences("data",Context.MODE_PRIVATE)
        val isRemember = prefs?.getBoolean("remember_password",false)
        if (isRemember!!) {
            binding.passwordInput.editText?.setText(prefs.getString("password",""))
            binding.accountInput.editText?.setText(prefs.getString("account",""))
            binding.rememberPass.isChecked = true
        }

        binding.forgetpassword.apply {
            paint.flags = Paint.UNDERLINE_TEXT_FLAG
            paint.isAntiAlias = true
        }

        binding.loginButton.setOnClickListener {
            val account = binding.accountInput.editText?.text.toString()
            val password = binding.passwordInput.editText?.text.toString()
            //登录验证逻辑
            if (account.isNotEmpty() && password.isNotEmpty()){
                val edit = activity?.getSharedPreferences("data",Context.MODE_PRIVATE)!!.edit()
                if (binding.rememberPass.isChecked) {
                    edit?.apply {
                        putBoolean("remember_password",true)
                        putString("account",account)
                        putString("password",password)
                    }

                }else{
                    edit?.clear()
                }
                edit.apply()
                Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_homeFragment)
            }

        }

        binding.signupButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_signupFragment)
        }
    }

}