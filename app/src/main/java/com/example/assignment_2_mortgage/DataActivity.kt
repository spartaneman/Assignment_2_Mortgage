package com.example.assignment_2_mortgage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assignment_2_mortgage.databinding.ActivityDataActivityBinding

class DataActivity : AppCompatActivity() {
    private var binding: ActivityDataActivityBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDataActivityBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.btnDone!!.setOnClickListener {
            goBack()
        }
    }

    private fun  goBack()
    {
        finish()
    }


}