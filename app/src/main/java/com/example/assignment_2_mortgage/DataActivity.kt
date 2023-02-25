package com.example.assignment_2_mortgage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assignment_2_mortgage.databinding.ActivityDataActivityBinding

class DataActivity : AppCompatActivity() {

    private val mortgage: Mortgage = MainActivity.mortgage

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
        updateMortgageObject()
        finish()
        overridePendingTransition(R.anim.fade_in_and_scale, 0)
    }

    private fun updateView(){
        val newYears = mortgage.getYears()
        binding!!.rgYears.check(when(newYears)
        {
            10 -> binding!!.rbTen.id
            15 -> binding!!.rbFifteen.id
            else -> binding!!.rbThirty.id
        })

        binding!!.etDataAmount.setText(mortgage.getAmount().toString())
        binding!!.etInterestRate.setText(mortgage.getRate().toString())
    }

    private fun updateMortgageObject()
    {
        val pf = Prefs(this)
        val newYears = when(binding!!.rgYears.checkedRadioButtonId)
        {
            binding!!.rbTen.id -> 10
            binding!!.rbFifteen.id -> 15
            else -> 30
        }
        mortgage.setYears(newYears)
        val etAmount = binding!!.etDataAmount.text.toString()
        val etRate = binding!!.etInterestRate.text.toString()

        try {
            mortgage.setAmount(etAmount.toFloat())
            mortgage.setRate(etRate.toFloat())
            pf.setPreferences(mortgage)
        }catch (nfe: java.lang.NumberFormatException)
        {
            mortgage.setAmount(100000.0f)
            mortgage.setRate(0.035f)
        }





    }

    override fun onStart() {
        super.onStart()
        updateView()
    }

}