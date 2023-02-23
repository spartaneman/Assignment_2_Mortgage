package com.example.assignment_2_mortgage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.assignment_2_mortgage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnModifyData?.setOnClickListener {
            modifyData()
        }

    }

    fun modifyData(){
        val myIntent = Intent(this, DataActivity::class.java)
        startActivity(myIntent)
    }
}