package com.atreus.asisapp.home.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.atreus.asisapp.account.LoginActivity
import com.atreus.asisapp.databinding.FragmentProfileBinding
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth


class Profile : Fragment() {

    private var _binding : FragmentProfileBinding? = null
    lateinit var auth: FirebaseAuth

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    //Code untuk memanggil data firebase, email, username, logout
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        if (user != null){
            binding.edtName.setText(user.displayName)
            binding.edtEmail.setText(user.email)
        }

        binding.btnLogout.setOnClickListener{
            btnLogout()
        }
    }

    //Logout user
    private fun btnLogout() {
        auth = FirebaseAuth.getInstance()
        auth.signOut()
        val intent  = Intent(context,LoginActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }
}