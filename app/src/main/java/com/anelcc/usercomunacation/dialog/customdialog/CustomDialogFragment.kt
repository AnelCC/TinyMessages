package com.anelcc.usercomunacation.dialog.customdialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import com.anelcc.usercomunacation.R

class CustomDialogFragment : DialogFragment() {
    private val TAG = "CustomDialogFragment"

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity!!)

        // Create the custom layout using the LayoutInflater class
        val inflater = activity!!.layoutInflater
        val v = inflater.inflate(R.layout.custom_dialog_layout, null)

        // Build the dialog
        builder.setTitle("Please enter your info")
            .setPositiveButton("OK") { dialog, which -> Log.i(TAG, "OK Clicked") }
            .setNegativeButton("Cancel") { dialog, which -> Log.i(TAG, "Cancel clicked") }
            .setView(v)

        return builder.create()
    }
}
