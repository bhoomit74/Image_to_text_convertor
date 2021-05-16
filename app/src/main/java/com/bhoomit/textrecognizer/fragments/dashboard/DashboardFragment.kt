package com.bhoomit.textrecognizer.fragments.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bhoomit.textrecognizer.databinding.FragmentDashboardBinding
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition

class DashboardFragment : Fragment() {

    private lateinit var mBinding : FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDashboardBinding.inflate(inflater, container, false)
        initData()
        initObserver()
        return mBinding.root
    }

    private fun initData() {
        mBinding.pickImage.setOnClickListener {
            pickImage()
        }
    }

    private fun initObserver() {

    }

    private fun pickImage(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent,1000)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(data!=null){
            val uri = data.data
            val inputImage = InputImage.fromFilePath(requireContext(),uri!!)
            val recognizer = TextRecognition.getClient()
            recognizer.process(inputImage).addOnSuccessListener {
                mBinding.text.text = it.text
            }.addOnFailureListener {
                Toast.makeText(requireContext(),it.message,Toast.LENGTH_SHORT).show()
            }

        }
    }
}