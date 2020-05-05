package com.anelcc.usercomunacation.notification

import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import com.anelcc.usercomunacation.R

class NotificationActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        private val NOTIFY_ID = 1001
        private val NOTIFY_CHANNEL = "MY_CHANNEL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        findViewById<View>(R.id.btnNotification).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        createNotification()
    }

    private fun createNotification() {
        val builder = NotificationCompat.Builder(this, NOTIFY_CHANNEL)
        // Set the three required items all notifications must have
        builder.setSmallIcon(R.drawable.ic_notifications_accent)
        builder.setContentTitle("Sample Notification")
        builder.setContentText("This is a sample notification")
        // Set the notification to cancel when the user taps on it
        builder.setAutoCancel(true)
        // Set the large icon to be our app's launcher icon
        builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.user_woman_icon))

        // Build the finished notification and then display it to the user
        val notification = builder.build()
        val mgr = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        mgr.notify(NOTIFY_ID, notification)
    }
}
