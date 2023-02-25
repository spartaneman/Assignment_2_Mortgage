package com.example.assignment_2_mortgage
import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class Prefs (context1: Context) {
    private var context: Context? = context1
    private var amount: Float = 100000.0f
    private var years: Int = 30
    private var rate: Float = 0.035f

    companion object{
        private const val MORTGAGE: String = "Mortgage"
    }

    fun setPreferences(mort: Mortgage)
    {
        var sp: SharedPreferences?= context!!.getSharedPreferences(MORTGAGE, Context.MODE_PRIVATE)
        var editor = sp?.edit()
        if (editor != null){
            editor.putFloat(Mortgage.PREFERENCE_AMOUNT, mort.getAmount())
        }
        if(editor != null){
            editor.putInt(Mortgage.PREFERENCE_YEARS, mort.getYears())
        }
        if(editor != null){
            editor.putFloat(Mortgage.PREFERENCE_RATE, mort.getRate())
        }
    }

    fun getPreferences(mort: Mortgage)
    {
        var sp: SharedPreferences? = context!!.getSharedPreferences(MORTGAGE,Context.MODE_PRIVATE)
        if(sp != null){
            mort.setYears(sp.getInt(Mortgage.PREFERENCE_YEARS,years))
            mort.setRate(sp.getFloat(Mortgage.PREFERENCE_RATE,rate))
            mort.setAmount(sp.getFloat(Mortgage.PREFERENCE_AMOUNT, amount))
        }
    }
}