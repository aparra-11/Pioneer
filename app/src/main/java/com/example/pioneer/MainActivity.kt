package com.example.pioneer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Mindera", "onCreate")

        val text = findViewById<TextView>(R.id.main_activity_textview)
        val edit = findViewById<EditText>(R.id.main_activity_edittext)
        val button = findViewById<Button>(R.id.main_activity_button)
        button.setOnClickListener {
            text.text = edit.text.toString()
        }

        edit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                button.setBackgroundColor(resources.getColor(R.color.green))
                text.setTextColor(resources.getColor(R.color.green))
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (edit.text.toString() == "André") {
                    Log.d("testLogs", "im in")
                    text.setTextColor(resources.getColor(R.color.blue))
                    button.setBackgroundColor(resources.getColor(R.color.blue))
                } else if (edit.text.toString() == "Tiago") {
                    button.setBackgroundColor(resources.getColor(R.color.red))
                    text.setTextColor(resources.getColor(R.color.red))
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

    }

    override fun onStart() {
        super.onStart()
        Log.d("Mindera", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Mindera", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Mindera", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Mindera", "onStop")
    }

    override fun onDestroy() {
        Log.d("Mindera", "onDestroy")
        super.onDestroy()
    }
}