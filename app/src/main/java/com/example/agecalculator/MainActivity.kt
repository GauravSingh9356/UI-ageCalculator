package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDatePicker.setOnClickListener {view->
            clickDatePicker(view)
        }
    }
    fun clickDatePicker(view: View){
        val mycalendar=Calendar.getInstance()
        val year=mycalendar.get(Calendar.YEAR)
        val month=mycalendar.get(Calendar.MONTH)
        val day=mycalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,
        DatePickerDialog.OnDateSetListener {
                view, selectedyear, selectedmonth, selecteddayOfMonth ->
            val selectedDate="$selecteddayOfMonth/${selectedmonth+1}/$selectedyear"


            val sdf=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate=sdf.parse(selectedDate)
            tvselectedDate.setText(theDate.toString())
        }
        , year, month, day).show()
    }
}
