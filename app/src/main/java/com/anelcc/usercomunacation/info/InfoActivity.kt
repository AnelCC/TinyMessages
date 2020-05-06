package com.anelcc.usercomunacation.info

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.anelcc.usercomunacation.R

class InfoActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        findViewById<View>(R.id.btn_github).setOnClickListener(this)
        findViewById<View>(R.id.btn_linkedin).setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_github -> goGitHub()
            R.id.btn_linkedin -> goLinkedIn()
        }
    }

    private fun goGitHub() {
        val openURL = Intent(android.content.Intent.ACTION_VIEW)
        openURL.data = Uri.parse("https://github.com/AnelCC/UserComunication")
        startActivity(openURL)
    }

    private fun goLinkedIn() {
        val openURL = Intent(android.content.Intent.ACTION_VIEW)
        openURL.data = Uri.parse("https://www.linkedin.com/in/anelcalvo/")
        startActivity(openURL)
    }
}
