package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var isNewOperator = true
    lateinit var textView:TextView
    var lastNum : Boolean =false
    var lastDot : Boolean =false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView  = findViewById<TextView>(R.id.editText)
        lastNum =true

    }

    fun onDigit (view : View){
        textView.append((view as Button).text)

    }

    fun onClear(view: View ){
        textView.text =""
        lastNum =true
        lastDot =false

    }

    fun onBackSpace(view : View){
        var s = textView.text.toString()
        if(s != ""){
            if(s[s.length-1] == '.'){
                lastNum =true
                lastDot =false
            }
            s= s.substring(0,s.length-1)
            textView.text = s
        }

    }

    fun onDecimalPoint(view :View){
        if(lastNum && !lastDot){
            textView.append(".")
            lastNum =false
            lastDot =true
        }
    }
}

