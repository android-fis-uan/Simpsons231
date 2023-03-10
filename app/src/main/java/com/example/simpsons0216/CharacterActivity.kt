package com.example.simpsons0216

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simpsons0216.databinding.ActivityCharacterBinding

class CharacterActivity : AppCompatActivity() {

    lateinit var binding: ActivityCharacterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra("NAME")
        val data = intent.getSerializableExtra("DATA") as SimpsonCharacter
        binding.title.text = data.fullName
        binding.description.text = data.description
        binding.characterImage.setImageResource(data.photo)
        binding.btnSave.setOnClickListener { save() }

    }

    fun save() {
        val data = intent.getSerializableExtra("DATA") as SimpsonCharacter
        val name = data.fullName
        val result = Intent()
        result.putExtra("RESULT", "Bye $name")
        setResult(Activity.RESULT_OK, result)
        finish()
    }
}