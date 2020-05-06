package com.anelcc.usercomunacation.dialog.SingleChoiceDialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class SingleChoiceDialogFragment : DialogFragment() {
    private val TAG = "AUC_COMPLEX"
    private val colors = arrayOf("Red", "Blue", "Green", "Yellow")

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)

        builder.setTitle("What Is Your Favorite Color?")

        builder.setItems(colors) { dialog, which ->
            Log.i(
                TAG, String.format("Dialog: Color chosen: %s", colors[which])
            )
        }

        return builder.create()
    }
}
