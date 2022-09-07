package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button=findViewById<Button>(R.id.button)
        button.setOnClickListener{view->
            printAge(view)
        }
    }
    private fun printAge(view:View){
        val calender=Calendar.getInstance()
        var year=calender.get(Calendar.YEAR)
        var month=calender.get(Calendar.MONTH)
        var day=calender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{view,year,month,day ->

                val selectedDate="$day/${month+1}/$year"
                var textview=findViewById<TextView>(R.id.textview)
                textview.text=selectedDate

                var textview2=findViewById<TextView>(R.id.textview2)
                var dob=Calendar.getInstance()
                dob.set(year,month,day)

                var age=calender.get(Calendar.YEAR) - dob.get(Calendar.YEAR)
                if(calender.get(Calendar.DAY_OF_YEAR)<dob.get(Calendar.DAY_OF_YEAR)){
                        age--;
                }
                var textview3=findViewById<TextView>(R.id.textview3)
                textview3.text="Your age is $age"

            }
            ,year
            ,month
            ,day).show()
    }

}