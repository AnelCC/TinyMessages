package com.anelcc.usercomunacation.dialog.simpledialog

import androidx.fragment.app.DialogFragment

interface SimpleDialogListener {
    fun onPositiveResult(dlg: DialogFragment)
    fun onNegativeResult(dlg: DialogFragment)
    fun onNeutralResult(dlg: DialogFragment)
}
