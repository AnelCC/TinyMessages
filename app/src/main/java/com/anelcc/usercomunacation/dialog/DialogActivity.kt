package com.anelcc.usercomunacation.dialog

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.anelcc.usercomunacation.R
import com.anelcc.usercomunacation.dialog.SingleChoiceDialog.SingleChoiceDialogFragment
import com.anelcc.usercomunacation.dialog.simpledialog.SimpleDialogFragment
import com.anelcc.usercomunacation.dialog.simpledialog.SimpleDialogListener
import java.util.*

class DialogActivity : AppCompatActivity(), View.OnClickListener, SimpleDialogListener {
    private val TAG = "DialogActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        findViewById<View>(R.id.btnSimpleDialog).setOnClickListener(this)
        findViewById<View>(R.id.btnShowDatePicker).setOnClickListener(this)
        findViewById<View>(R.id.btnShowChoiceDialog).setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnSimpleDialog -> showSimpleDialog()
            R.id.btnShowDatePicker ->  showCalendar()
            R.id.btnShowChoiceDialog -> showChoiceDialog()
        }
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

    private fun showCalendar() {
        // Get a calendar instance
        val cal = Calendar.getInstance()
        // Create a DatePickerDialog
        val datePicker = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                Log.i(TAG, String.format("Date Chosen -- day: %d, month: %d, year: %d", dayOfMonth, monthOfYear, year)) },
            cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))
        // Set the title and show the dialog
        datePicker.setTitle("Choose a Date")
        datePicker.show()
    }

    private fun showChoiceDialog() {
        Log.i(TAG, "showChoiceDialog")
        val complexDialog = SingleChoiceDialogFragment()
        complexDialog.show(supportFragmentManager, "SingleChoiceDialogFragment")
    }
}
