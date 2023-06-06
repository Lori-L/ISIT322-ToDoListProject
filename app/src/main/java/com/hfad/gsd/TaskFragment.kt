package com.hfad.gsd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class TaskFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task, container, false)

//        val myButton = findViewById<Button>(R.id.createButton)

//        myButton.setOnClickListener {
//            val name = fieldOne.text.toString()
//            val description = fieldTwo.text.toString()
//            val location = fieldThree.text.toString()
    }
}



