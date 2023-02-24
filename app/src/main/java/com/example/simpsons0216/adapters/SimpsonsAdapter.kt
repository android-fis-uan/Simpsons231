package com.example.simpsons0216.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.simpsons0216.MainActivity
import com.example.simpsons0216.R

class SimpsonsAdapter(val activity:MainActivity, val layout: Int, val data:ArrayList<String>)
    : ArrayAdapter<String>(activity, layout, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = activity.layoutInflater.inflate(layout, null)
        val icon = view.findViewById<ImageView>(R.id.icon)
        val id = activity.resources.getIdentifier(data[position].lowercase(), "drawable", activity.packageName)
        icon.setImageResource(id)
        val name = view.findViewById<TextView>(R.id.name)
        name.text = data[position]
        return view
    }


}