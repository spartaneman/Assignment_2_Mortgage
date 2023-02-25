package com.example.assignment_2_mortgage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.assignment_2_mortgage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val pf: Prefs = Prefs(this)
    companion object{
        val mortgage = Mortgage()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pf.getPreferences(mortgage)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnModifyData?.setOnClickListener {
            modifyData()
        }

    }

    private fun modifyData(){
        val myIntent = Intent(this, DataActivity::class.java)
        startActivity(myIntent)
        overridePendingTransition(R.anim.slide_from_left, 0)
    }

    private fun updateView(){
        binding?.tvAmount?.text = mortgage.getAmount().toString()
        binding?.tvRate?.text = mortgage.getRate().toString()
        binding?.tvYears?.text = mortgage.getYears().toString()
        binding?.tvPayment?.text = mortgage.formattedMonthlyPayment()
        binding?.tvTotal?.text = mortgage.formattedTotalPayment()
    }

    override fun onStart() {
        super.onStart()
        updateView()
    }
}