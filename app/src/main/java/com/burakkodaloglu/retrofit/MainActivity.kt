package com.burakkodaloglu.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.burakkodaloglu.retrofit.common.viewBinding
import com.burakkodaloglu.retrofit.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}