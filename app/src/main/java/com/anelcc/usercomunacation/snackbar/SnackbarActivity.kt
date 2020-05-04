package com.anelcc.usercomunacation.snackbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.anelcc.usercomunacation.R
import com.google.android.material.snackbar.Snackbar

class SnackbarActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar)

        findViewById<View>(R.id.snackbar_show_snackbar).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        showSnackbar()
    }

    private fun showSnackbar() {
        // Create and show the snackbar
        Snackbar.make(findViewById(R.id.snackbar_coordinator_layout), "This is a snackbar LENGTH_LONG", Snackbar.LENGTH_LONG).show()
    }
}
