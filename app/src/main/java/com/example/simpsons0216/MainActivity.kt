package com.example.simpsons0216

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.simpsons0216.adapters.SimpsonsAdapter
import com.example.simpsons0216.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding:ActivityMainBinding? = null
    val simpsonNames = arrayListOf<String>("Homer","Bart","Lisa")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        // 1. create the adapter object
        //val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, simpsonNames);
        val adapter = SimpsonsAdapter(this, R.layout.list_simpsons, simpsonNames);
        // 2. connect the list with the adapter
        binding?.simpsonList?.adapter = adapter
        binding?.simpsonList?.setOnItemClickListener { parent, view, position, id ->
            println("\n-parent: $parent" +
                    "\n-view: $view" +
                    "\n-position: $position" +
                    "\n-id $id")
            changeImage(simpsonNames[position].lowercase())
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
