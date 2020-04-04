package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    var billTotal: Double = 0.00
    var selection: Double = 0.00
    var tipTotal: Double = 0.00
    val currency = DecimalFormat("$###,###.00")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preTip: EditText = findViewById(R.id.billAmount)
        val dropdown: Spinner = findViewById(R.id.tipSelect)
        val calculate: Button = findViewById(R.id.btnCalculate)
        val result: TextView = findViewById(R.id.tipResult)

        calculate.setOnClickListener{
            billTotal = preTip.text.toString().toDouble()
            selection = dropdown.selectedItem.toString().replace("%", "").toDouble()
            tipTotal = billTotal * selection/100
            val output = currency.format(tipTotal)

            result.text = "Your tip total is: $output"

        }
    }
}
