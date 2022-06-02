package com.example.pioneer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Mindera", "onCreate")

        val text = findViewById<TextView>(R.id.main_activity_textview)
        val edit = findViewById<EditText>(R.id.main_activity_edittext)
        val button = findViewById<Button>(R.id.main_activity_button)
        val img = findViewById<ImageView>(R.id.main_activity_imageView)

        button.setOnClickListener {
            Log.d("testLogs", viewModel.initialImg.value.toString())
            Log.d("testLogs", viewModel.newImg.value.toString())
            text.text = edit.text.toString()
            viewModel.initialImg.value = viewModel.newImg.value
        }
        lifecycleScope.launchWhenCreated {
            viewModel.color.collect { color ->
                button.setBackgroundColor((resources.getColor(color)))
                text.setTextColor((resources.getColor((color))))
            }
            viewModel.initialImg.collect { newImage ->
                img.setImageResource(newImage)
            }
            viewModel.newImg.collect() { newImage ->
                img.setImageResource(newImage)
            }
        }

        edit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (edit.text.toString() == "André") {
                    viewModel.color.value = R.color.blue
                } else if (edit.text.toString() == "Tiago") {
                    viewModel.color.value = R.color.red
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
