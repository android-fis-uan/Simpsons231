package com.example.simpsons0216

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.simpsons0216.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding:ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.simpsonList?.setOnItemClickListener { parent, view, position, id ->
            println("\n-parent: $parent" +
                    "\n-view: $view" +
                    "\n-position: $position" +
                    "\n-id $id")
            simpsonsOnClick(view)
        }
    }

    fun simpsonsOnClick(view: View) {
        val b = view as TextView
        changeImage(b.text.toString().lowercase())
    }

    fun changeImage(character:String) {
        val image = resources.getIdentifier(character, "drawable", packageName)
        binding?.simpsonImage?.setImageResource(image)
    }
}