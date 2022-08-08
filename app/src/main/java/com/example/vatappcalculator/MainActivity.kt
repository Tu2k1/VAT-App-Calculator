package com.example.vatappcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vatappcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root // reference to layout file
        setContentView(view) // link the layout to the app

        binding.calculateVatButton.setOnClickListener {
            calculateVat()
        }
    }

    private fun calculateVat() {
        val totalCost = binding.totalCostEditText.text.toString().toDouble()

        val vatPercentage = when(binding.vatOptions.checkedRadioButtonId){
            R.id.vat_ten -> 0.10
            R.id.vat_fifteen -> 0.15
            else -> 0.20
        }

        val vat = totalCost * vatPercentage

        var total = totalCost + vat

        if(binding.roundUpSwitch.isChecked){
            total = kotlin.math.ceil(total)
        }
        formatting(totalCost, vat, total)
    }

    private fun formatting(totalCost: Double, vat: Double, total: Double) {
        val formattedCost = NumberFormat.getCurrencyInstance().format(totalCost)
        val formattedVat = NumberFormat.getCurrencyInstance().format(vat)
        val formattedTotal = NumberFormat.getCurrencyInstance().format(total)

        binding.finalCost.text = getString(R.string.cost, formattedCost)
        binding.finalVat.text = getString(R.string.vat, formattedVat)
        binding.finalTotal.text = getString(R.string.total_amount, formattedTotal)
    }
}