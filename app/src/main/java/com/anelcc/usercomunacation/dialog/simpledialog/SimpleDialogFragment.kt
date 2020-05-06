package com.anelcc.usercomunacation.dialog.simpledialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class SimpleDialogFragment : DialogFragment() {
    private val TAG = "SimpleDialogFragment"
    private var simpleDialogListener: SimpleDialogListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity!!)

        builder.setTitle("Peas Preference")
        builder.setMessage("Do you like sugar snap peas?")
        builder.setPositiveButton("Sure!") { dialog, which ->
            simpleDialogListener!!.onPositiveResult(this@SimpleDialogFragment)
        }
        builder.setNegativeButton("No way!") { dialog, which ->
            simpleDialogListener!!.onNegativeResult(this@SimpleDialogFragment)
        }
        builder.setNeutralButton("Not Sure") { dialog, which ->
            simpleDialogListener!!.onNeutralResult(this@SimpleDialogFragment)
        }
        return builder.create()
    }

    override fun onCancel(dlg: DialogInterface) {
        super.onCancel(dlg)
        Log.i(TAG, "Dialog cancelled")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SimpleDialogListener) {
            simpleDialogListener = context as SimpleDialogListener
        } else {
            throw RuntimeException(context!!.toString() )
        }
    }
}
