package com.practice.coroutinepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.practice.coroutinepractice.databinding.ActivityMainBinding
import com.practice.coroutinepractice.fragments.SecondFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView,SecondFragment()).commit()
    }
}