package com.hfad.gsd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val viewButton = view.findViewById<Button>(R.id.view)

        viewButton.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_mainFragment_to_taskFragment)
        }
        return view
    }
}