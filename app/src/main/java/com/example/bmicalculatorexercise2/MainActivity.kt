package com.example.bmicalculatorexercise2

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener(){

            val weight:Double = text_weight.text.toString().toDouble()

            val height:Double = text_height.text.toString().toDouble()

            val bmi = CalculateBMI(weight,height)

            val status:String

            val bmiImage: ImageView = findViewById(R.id.bmiImage)

            if (bmi < 18.5){
                status = "Underweight"
                bmiImage.setImageResource(R.drawable.under)
            }
            else if(bmi < 24.9){
                status = "Normal"
                bmiImage.setImageResource(R.drawable.normal)
            }
            else{
                status = "Overweight"
                bmiImage.setImageResource(R.drawable.over)
            }
            text_BMI.text = "%.2f (%s)".format(bmi, status)
        }

        btnReset.setOnClickListener(){
            bmiImage.setImageResource(R.drawable.empty)
            text_BMI.text = ""
            text_weight.setText("")
            text_height.text = null

            text_weight.requestFocus()
        }
    }


    fun CalculateBMI(weight:Double, height:Double):Double{
        return weight / (height * height)
    }

}
