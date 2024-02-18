package com.example.activityandfragmentinteraction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.activityandfragmentinteraction.Interface.ActivityInterface

class MainActivity : AppCompatActivity() {
    var count = 0
    var etName : EditText?= null
    var btnSubmit : Button?= null
    var red : Button ?= null
    var green : Button ?= null
    var blue : Button ?= null


    lateinit var tvCount : TextView
    lateinit var activityInterface: ActivityInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvCount = findViewById(R.id.tvCount)
        etName = findViewById(R.id.etName)
        btnSubmit = findViewById(R.id.btnSubmit)
        red = findViewById(R.id.red)
        green = findViewById(R.id.green)
        blue = findViewById(R.id.blue)



        red?.setOnClickListener(){
            ActivityInterface.colorname(R.color.Red)
        }
        green?.setOnClickListener(){
            ActivityInterface.colorname(R.color.Green)
        }
        blue?.setOnClickListener(){
            ActivityInterface.colorname(R.color.Blue)
        }

        btnSubmit?.setOnClickListener(){
            if (etName?.text.toString().isNullOrEmpty()){
                etName?.error = "Enter Something"
            }
            else{
                ActivityInterface.getValue(etName?.text.toString())
            }
        }


    }
    fun incNumber(){
        count = count + 1
        tvCount.setText(count.toString())
    }
    fun decNumber(){
        if(count == 0){
            Toast.makeText(this,"Number cannot be Negative button",Toast.LENGTH_SHORT).show()
        }
        else{
            count = count - 1
            tvCount.setText(count.toString())
        }
    }
}