package com.bhoomit.textrecognizer.fragments.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bhoomit.textrecognizer.R
import com.bhoomit.textrecognizer.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    private lateinit var mBinding : FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentSplashBinding.inflate(inflater, container, false)
        initData()
        return mBinding.root
    }

    private fun initData() {
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_dashboardFragment)
        },2000)
    }

}