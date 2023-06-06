package com.hfad.gsd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.content.Context
import androidx.navigation.findNavController

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val viewButton = view.findViewById<Button>(R.id.view)
        val notifyButton = view.findViewById<Button>(R.id.notification)
        val service = context?.let { CounterNotificationService(it) }
        // ^^^ was originally val service = CounterNotificationService(context),

        viewButton.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_mainFragment_to_taskFragment)
        }

        notifyButton.setOnClickListener {
            if (service != null) {
                service.showNotification(Counter.value)
            }
        }
        return view
    }
}