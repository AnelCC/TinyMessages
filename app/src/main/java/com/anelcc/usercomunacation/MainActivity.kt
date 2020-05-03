package com.anelcc.usercomunacation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.activity_launch_toast).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Log.d("MainActivity", "LaunchToast ")
        startActivity(Intent(this, ToastActivity::class.java))
    }
}
