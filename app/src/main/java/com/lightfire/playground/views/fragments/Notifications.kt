package com.lightfire.playground.views.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.lightfire.playground.R
import kotlinx.android.synthetic.main.fragment_notifications.*
import kotlin.LazyThreadSafetyMode.NONE

class Notifications : Fragment() {

    private val title by lazy(NONE) { arguments?.getString("title") ?: "" }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        notificationsFragmentLabel.text = title
        openNotificationDetailsButton.setOnClickListener {
            val action = NotificationsDirections.openNotificationDetailsAction()
            action.setNotificationId("Test")
            val navController = view.findNavController()
            navController.navigate(action)
        }
    }
}