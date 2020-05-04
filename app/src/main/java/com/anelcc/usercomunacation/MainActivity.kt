package com.anelcc.usercomunacation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.anelcc.usercomunacation.dialog.DialogActivity
import com.anelcc.usercomunacation.snackbar.SnackbarActivity
import com.anelcc.usercomunacation.toast.ToastActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.activity_launch_toast).setOnClickListener(this)
        findViewById<View>(R.id.activity_launch_snackbar).setOnClickListener(this)
        findViewById<View>(R.id.activity_launch_dialog).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.activity_launch_toast -> startActivity(Intent(this, ToastActivity::class.java))
            R.id.activity_launch_snackbar -> startActivity(Intent(this, SnackbarActivity::class.java))
            R.id.activity_launch_dialog -> startActivity(Intent(this, DialogActivity::class.java))
        }
    }
}
