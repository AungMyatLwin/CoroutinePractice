package com.practice.coroutinepractice.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.practice.coroutinepractice.R
import com.practice.coroutinepractice.databinding.FragmentSecondBinding
import com.practice.coroutinepractice.room.ProfileEntity
import com.practice.coroutinepractice.viewmodel.MyViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SecondFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var _binding:FragmentSecondBinding?=null
    private val binding get() = _binding!!
    private lateinit var vm:MyViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vm= ViewModelProvider(this).get(MyViewModel::class.java)
        Log.d("Test", "onCreateView: ${vm.getAllUsers()}")


        lifecycleScope.launch {
           withContext(Dispatchers.IO){
               vm.insertUser(ProfileEntity(7, "Aung", 24))
               vm.insertUser(ProfileEntity(1, "Aung", 29))
               vm.insertUser(ProfileEntity(2, "Aung", 30))
               vm.insertUser(ProfileEntity(0, "AungZ", 36))
           }
        }

        vm.userlist.observe(viewLifecycleOwner){
                userList ->
            Log.d("Test", "onCreateView: ${userList}")
            if (userList != null) {
                binding.name.text = userList[userList.size-1].name.toString()
            }
        }

        _binding= FragmentSecondBinding.inflate(layoutInflater,container,false)

        vm.getData()
        vm.mutableLiveDataResponse.observe(viewLifecycleOwner, Observer{
            Log.d(TAG,"${it.body()}")
        })
        return binding.root
    }
}