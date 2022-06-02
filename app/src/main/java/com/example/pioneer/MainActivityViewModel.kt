package com.example.pioneer

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivityViewModel: ViewModel(){
    var color = MutableStateFlow(R.color.green)
    var initialImg = MutableStateFlow(R.drawable.mindera)
    var newImg = MutableStateFlow(R.drawable.mindera_school)
}