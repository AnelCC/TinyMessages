package com.anelcc.usercomunacation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.RadioButton
import android.widget.Toast

class ToastActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)


        findViewById<View>(R.id.btnShowToast).setOnClickListener(this)
        findViewById<View>(R.id.btnShowCustomToast).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnShowToast -> showToast()
        }
    }
    private fun showToast() {
        var toastType = "";
        val toastDuration: Int
        val rbShort = findViewById<View>(R.id.rbShort) as RadioButton
        if (rbShort.isChecked) {
            toastType = "Short"
            toastDuration = Toast.LENGTH_SHORT
        }  else {
            toastType = "Long"
            toastDuration = Toast.LENGTH_LONG
        }

        // Create and show the toast message
        val toast = Toast.makeText(this, "This is a toast $toastType", toastDuration)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }
}
