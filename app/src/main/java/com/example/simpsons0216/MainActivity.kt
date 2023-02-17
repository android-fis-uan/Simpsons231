package com.example.simpsons0216

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simpsons0216.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding:ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.btnHomer?.setOnClickListener { changeImage("homer") }
        binding?.btnBart?.setOnClickListener { changeImage("bart") }
    }

    fun changeImage(character:String) {
        val image = resources.getIdentifier(character, "drawable", packageName)
        binding?.simpsonImage?.setImageResource(image)
    }
}