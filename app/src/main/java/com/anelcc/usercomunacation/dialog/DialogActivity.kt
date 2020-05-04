package com.anelcc.usercomunacation.dialog

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.anelcc.usercomunacation.R
import com.anelcc.usercomunacation.dialog.simpledialog.SimpleDialogFragment
import com.anelcc.usercomunacation.dialog.simpledialog.SimpleDialogListener

/*
A dialog is a small window that prompts the user to make a decision or enter additional information.
A dialog does not fill the screen and is normally used for modal events that require users to
take an action before they can proceed.

- Interumptive - stop current program flow
- Require the user to take action
- Maintain the user's current context
*/
class DialogActivity : AppCompatActivity(), View.OnClickListener,
    SimpleDialogListener {
    private val TAG = "DialogActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        findViewById<View>(R.id.btnSimpleDialog).setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        showSimpleDialog()

    }

    private fun showSimpleDialog() {
        val simpleDialog =
            SimpleDialogFragment()
        simpleDialog.setCancelable(false);
        simpleDialog.show(supportFragmentManager, "SimpleDialogFragment")
    }

    override fun onPositiveResult(dlg: DialogFragment) {
        Log.i(TAG, "onPositiveResult")
    }

    override fun onNegativeResult(dlg: DialogFragment) {
        Log.i(TAG, "onNegativeResult")
    }

    override fun onNeutralResult(dlg: DialogFragment) {
        Log.i(TAG, "onNeutralResult")
    }
}
