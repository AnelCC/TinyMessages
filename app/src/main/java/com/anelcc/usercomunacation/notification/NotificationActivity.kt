package com.anelcc.usercomunacation.notification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
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

        findViewById<View>(R.id.btn_simple_notification).setOnClickListener(this)
        findViewById<View>(R.id.btn_large_notification).setOnClickListener(this)
        findViewById<View>(R.id.btn_action_notification).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_simple_notification -> createNotification()
            R.id.btn_large_notification -> createLargeNotification()
            R.id.btn_action_notification -> createActionNotification()
        }
    }

    private fun createNotification() {
        val builder = NotificationCompat.Builder(this, NOTIFY_CHANNEL)
        // Set the three required items all notifications must have
        builder.setSmallIcon(R.drawable.ic_notifications_accent)
        builder.setContentTitle("Sample Notification")
        builder.setContentText("This is a sample Expanded Notification")
        // Set the notification to cancel when the user taps on it
        builder.setAutoCancel(true)
        // Set the large icon to be our app's launcher icon
        builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.user_woman_icon))

        // Build the finished notification and then display it to the user
        val notification = builder.build()
        val mgr = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        mgr.notify(NOTIFY_ID, notification)

    }


    private fun createLargeNotification() {
        val builder = NotificationCompat.Builder(this, NOTIFY_CHANNEL)
        builder.setSmallIcon(R.drawable.ic_notifications_accent)
        builder.setContentTitle("Sample Large Notification")
        builder.setContentText("More text here. Expand!")
        builder.setAutoCancel(true)
        builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.user_woman_icon))
        // Add an expanded layout to the notification
        val bigTextStyle = NotificationCompat.BigTextStyle()
        bigTextStyle.setBigContentTitle("This is a Expand Notification")
        bigTextStyle.bigText(resources.getString(R.string.long_msg))
        builder.setStyle(bigTextStyle)

        // Build the finished notification and then display it to the user
        val notification = builder.build()
        val mgr = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        mgr.notify(NOTIFY_ID, notification)
    }

    private fun createActionNotification() {
        val builder = NotificationCompat.Builder(this, NOTIFY_CHANNEL)
        // Create the intent that will start the ResultActivity when the user
        // taps the notification or chooses an action button
        val intent = Intent(this, NotificationResultActivity::class.java)
        // Store the notification ID so we can cancel it later in the ResultActivity
        intent.putExtra("notifyID", NOTIFY_ID)
        val pendingIntent = PendingIntent.getActivity(this, NOTIFY_ID, intent, PendingIntent.FLAG_CANCEL_CURRENT)

        builder.setSmallIcon(R.drawable.ic_notifications_accent)
        builder.setContentTitle("Sample Large Notification")
        builder.setContentText("More text here. Expand!")
        builder.setAutoCancel(true)
        builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.user_woman_icon))
        // Set the small subtext message
        builder.setSubText("Tap to view")
        // Set the content intent to launch our result activity
        builder.setContentIntent(pendingIntent)
        val bigTextStyle = NotificationCompat.BigTextStyle()
        bigTextStyle.setBigContentTitle("This is a Expand Notification")
        bigTextStyle.bigText(resources.getString(R.string.long_msg))
        builder.setStyle(bigTextStyle)
        // Add action buttons to the Notification if they are supported
        // Use the same PendingIntent as we use for the main notification action
        builder.addAction(R.mipmap.ic_launcher, "Action 1", pendingIntent)
        builder.addAction(R.mipmap.ic_launcher, "Action 2", pendingIntent)

        val notification = builder.build()
        val mgr = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        mgr.notify(NOTIFY_ID, notification)
    }
}
