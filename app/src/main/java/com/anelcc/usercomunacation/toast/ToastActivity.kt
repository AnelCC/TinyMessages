package com.anelcc.usercomunacation.toast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import com.anelcc.usercomunacation.R

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
            R.id.btnShowCustomToast -> showCustomToast()
        }
    }
    private fun showToast() {
        var toastType: String
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

    private fun showCustomToast() {
        var toastType: String
        val toastDuration: Int
        val rbShort = findViewById<View>(R.id.rbShort) as RadioButton

        if (rbShort.isChecked) {
            toastType = "Short"
            toastDuration = Toast.LENGTH_SHORT
        } else {
            toastType = "Long"
            toastDuration = Toast.LENGTH_LONG
        }

        // Get the custom layout and inflate it
        val inflater = LayoutInflater.from(this)
        val layout = inflater.inflate(
            R.layout.custom_toast_layout, findViewById(
                R.id.customToastLayout
            ))

        // Build a toast message that uses the custom layout
        val tv = layout.findViewById(R.id.textContent) as TextView
        tv.text = "This is a custom toast $toastType"
        val toast = Toast(applicationContext)
        toast.duration = toastDuration
        toast.setGravity(Gravity.BOTTOM or Gravity.START, 100, 100)
        toast.view = layout
        toast.show()
    }
}
