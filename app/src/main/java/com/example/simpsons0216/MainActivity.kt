package com.example.simpsons0216

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.simpsons0216.adapters.SimpsonsAdapter
import com.example.simpsons0216.databinding.ActivityMainBinding

data class SimpsonCharacter(
    val name:String,
    val fullName: String,
    val description: String,
    val photo: Int
) {

}
class MainActivity : AppCompatActivity() {
    var binding:ActivityMainBinding? = null
    val simpsonNames = arrayListOf<String>("Homer","Bart","Lisa")
    val simpsonCharacters = arrayListOf<SimpsonCharacter>(
        SimpsonCharacter("Homer", "Homer Simpson", "homer is a man ...", R.drawable.homer),
        SimpsonCharacter("Bart", "Bartolomeo Simpson", "bart is a man ...", R.drawable.bart),
        SimpsonCharacter("Marge", "Marjorie Jacqueline Simpson", "Marjorie Jacqueline \"Marge\" Simpson is a character in the American animated sitcom The Simpsons and part of the eponymous family. Voiced by Julie Kavner, she first appeared on television in The Tracey Ullman Show short \"Good Night\" on April 19, 1987.", R.drawable.marge)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        // 1. create the adapter object
        //val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, simpsonNames)
        val adapter = SimpsonsAdapter(this, R.layout.list_simpsons, simpsonCharacters)
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
        //changeImage(b.text.toString().lowercase())
        // go to character activity
        val intentCharacter = Intent(this, CharacterActivity::class.java)
        startActivity(intentCharacter)
    }

    fun changeImage(character:String) {
        val image = resources.getIdentifier(character, "drawable", packageName)
        binding?.simpsonImage?.setImageResource(image)
    }
}
