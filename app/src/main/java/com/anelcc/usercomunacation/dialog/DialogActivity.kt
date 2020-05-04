package com.anelcc.usercomunacation.dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anelcc.usercomunacation.R

/*
A dialog is a small window that prompts the user to make a decision or enter additional information.
A dialog does not fill the screen and is normally used for modal events that require users to
take an action before they can proceed.

- Interumptive - stop current program flow
- Require the user to take action
- Maintain the user's current context

*/
class DialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
    }
}
