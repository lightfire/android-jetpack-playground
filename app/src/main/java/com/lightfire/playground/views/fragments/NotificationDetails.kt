package com.lightfire.playground.views.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lightfire.playground.R
import kotlinx.android.synthetic.main.fragment_notification_details.*

class NotificationDetails : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_notification_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
            val passedArguments = NotificationDetailsArgs.fromBundle(it)
            notificationDetailsLabel.text = passedArguments.notificationId
        }
    }
}