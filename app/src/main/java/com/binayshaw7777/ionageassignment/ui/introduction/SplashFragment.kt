package com.binayshaw7777.ionageassignment.ui.introduction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.binayshaw7777.ionageassignment.databinding.FragmentSplashBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding ?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentSplashBinding.inflate(inflater, container, false)

        launchPostIntroduction()

        return binding.root
    }

    private fun launchPostIntroduction() {
        lifecycleScope.launch(Dispatchers.Main) {
            delay(3000L)
            val action = SplashFragmentDirections.actionSplashFragmentToMoviesFragment()
            findNavController().navigate(action)
        }
    }
}