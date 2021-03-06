package com.anelcc.usercomunacation.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(NOTIFY_CHANNEL, "Notifications", importance)
            channel.description = "This is a notification channel"

            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager?.createNotificationChannel(channel)
        }
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
        builder.setSmallIcon(R.drawable.ic_notifications_accent)
        builder.setContentTitle("Sample Notification")
        builder.setContentText("This is a sample Expanded Notification")
        builder.setAutoCancel(true)
        builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.user_woman_icon))

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

        val bigTextStyle = NotificationCompat.BigTextStyle()
        bigTextStyle.setBigContentTitle("This is a Expand Notification")
        bigTextStyle.bigText(resources.getString(R.string.long_msg))
        builder.setStyle(bigTextStyle)

        val notification = builder.build()
        val mgr = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        mgr.notify(NOTIFY_ID, notification)
    }

    private fun createActionNotification() {
        val builder = NotificationCompat.Builder(this, NOTIFY_CHANNEL)
        val intent = Intent(this, NotificationResultActivity::class.java)
        intent.putExtra("notifyID", NOTIFY_ID)
        val pendingIntent = PendingIntent.getActivity(this, NOTIFY_ID, intent, PendingIntent.FLAG_CANCEL_CURRENT)

        builder.setSmallIcon(R.drawable.ic_notifications_accent)
        builder.setContentTitle("Sample Large Notification")
        builder.setContentText("More text here. Expand!")
        builder.setAutoCancel(true)
        builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.user_woman_icon))
        builder.setSubText("Tap to view")
        builder.setContentIntent(pendingIntent)

        val bigTextStyle = NotificationCompat.BigTextStyle()
        bigTextStyle.setBigContentTitle("This is a Expand Notification")
        bigTextStyle.bigText(resources.getString(R.string.long_msg))
        builder.setStyle(bigTextStyle)
        builder.addAction(R.mipmap.ic_launcher, "Action 1", pendingIntent)
        builder.addAction(R.mipmap.ic_launcher, "Action 2", pendingIntent)
        builder.setVisibility(NotificationCompat.VISIBILITY_SECRET)

        val notification = builder.build()
        val mgr = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        mgr.notify(NOTIFY_ID, notification)
    }
}
