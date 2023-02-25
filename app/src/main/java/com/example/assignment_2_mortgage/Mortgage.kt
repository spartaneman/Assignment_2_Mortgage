package com.example.assignment_2_mortgage

import java.text.DecimalFormat
class Mortgage {
    val MONEY: DecimalFormat = DecimalFormat("$#,##0.00")

    private var amount = 0f
    private var years = 0
    private var rate = 0f
    companion object{
        const val PREFERENCE_AMOUNT = "Amount"
        const val PREFERENCE_YEARS = "Years"
        const val PREFERENCE_RATE = "Rate"
    }

    fun Mortgage(){
        setAmount(100000.0f)
        setRate(0.035f)
        setYears(30)
    }

    fun setAmount(newAmount: Float)
    {
        if (newAmount >=0) amount = newAmount
    }

    fun setYears(newYears: Int)
    {
        if(newYears >= 0 ) years = newYears
    }

    fun setRate(newRate: Float)
    {
        if(newRate >=0 ) rate = newRate
    }

    fun getAmount(): Float{
        return amount
    }

    fun getFormattedAmount(): String?{
        return MONEY.format(amount)
    }

    fun getYears(): Int{
        return years
    }

    fun getRate(): Float{
        return rate
    }

    fun monthlyPayment(): Float{
        val mRate = rate/12
        val temp = Math.pow((1/(1+ mRate)).toDouble(), (years * 12).toDouble())
        return amount * (mRate/(1 - temp).toFloat())
    }

    fun formattedMonthlyPayment(): String?
    {
        return MONEY.format(monthlyPayment())
    }

    fun totalPayment() : Float{
        return monthlyPayment() * years * 12
    }

    fun  formattedTotalPayment(): String?
    {
        return MONEY.format(totalPayment())
    }
}