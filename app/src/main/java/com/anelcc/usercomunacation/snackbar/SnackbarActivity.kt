package com.anelcc.usercomunacation.snackbar

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.anelcc.usercomunacation.R
import com.google.android.material.snackbar.Snackbar

class SnackbarActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar)

        findViewById<View>(R.id.snackbar_show_snackbar).setOnClickListener(this)
        findViewById<View>(R.id.snackbar_show_action_snackbar).setOnClickListener(this)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onClick(v: View) {
        when (v.id) {
            R.id.snackbar_show_snackbar -> showSnackbar()
            R.id.snackbar_show_action_snackbar -> showActionSnackbar()
        }
    }

    // Create and show the simple snackbar
    private fun showSnackbar() {
        Snackbar.make(findViewById(R.id.snackbar_coordinator_layout), "This is a snackbar LENGTH_LONG", Snackbar.LENGTH_LONG).show()
    }

    // Create a custom snackbar that has an action item
    @RequiresApi(Build.VERSION_CODES.M)
    private fun showActionSnackbar() {
        val snackbar = Snackbar.make(findViewById(R.id.snackbar_coordinator_layout), "This is a snackbar", Snackbar.LENGTH_LONG)

        snackbar.setBackgroundTint(getColor(R.color.colorAccent))
        snackbar.setAction("Click here!") {
            Toast.makeText(applicationContext, "Snackbar Action Click!", Toast.LENGTH_SHORT).show()
        }
        snackbar.setActionTextColor(getColor(R.color.colorPrimaryDark))
        snackbar.show()
    }
}
