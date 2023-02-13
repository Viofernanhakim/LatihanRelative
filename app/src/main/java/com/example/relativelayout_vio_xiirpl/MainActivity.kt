package com.example.relativelayout_vio_xiirpl
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSpinnerDay()
        setSpinnerTime()
    }

    fun setSpinnerDay(){
        val Spinnerday:Spinner = findViewById(R.id.spinner_day)

        ArrayAdapter.createFromResource(
            this,
            R.array.day_array,
            com.google.android.material.R.layout.support_simple_spinner_dropdown_item
        ).also {
            it.setDropDownViewResource(
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item)
            Spinnerday.adapter = it
        }
    }
    fun setSpinnerTime(){
        val Spinner_date:Spinner = findViewById(R.id.spinner_date)

        ArrayAdapter.createFromResource(
            this,
            R.array.time_array,
            com.google.android.material.R.layout.support_simple_spinner_dropdown_item
        ).also {
            it.setDropDownViewResource(
                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item)
            Spinner_date.adapter = it
        }
    }
}