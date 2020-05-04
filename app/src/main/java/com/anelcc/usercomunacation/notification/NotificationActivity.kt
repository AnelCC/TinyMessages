package com.anelcc.usercomunacation.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anelcc.usercomunacation.R

/*
A notification is a message that Android displays outside your app's UI
to provide the user with reminders, communication from other people,
or other timely information from your app. Users can tap the notification
to open your app or take an action directly from the notification.

- Displays outside of you normal app user interface.
- Trigger specific parts of your application when tapped.
- Take various forms depending on their information.
- Can have individual action item associated.
- Can appear on the user's lock screen.
*/
class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
    }
}
