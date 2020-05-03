package com.anelcc.usercomunacation.snackbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anelcc.usercomunacation.R

/*
The Snackbar class provides static make methods to produce a snackbar configured in the desired way.
These methods take a View, which will be used to find a suitable ancestor ViewGroup to display
the snackbar in, a text string to display (either as a CharSequence or a resource ID),
and a duration to display the snackbar for (either a duration preset, or a time in milliseconds).
A suitable ancestor ViewGroup will be either the nearest CoordinatorLayout to the View passed in,
or the root DecorView if none could be found.

Available duration presets are:
LENGTH_INDEFINITE
LENGTH_LONG
LENGTH_SHORT

- Displays a short, momentary text message
- Displays a quick messages to acknowledges something
- Can be displayed fro a short or longer amount of time.
- Appear of the bottom of the screen
- Have the ability to specify a clickleable action.
*/

class SnackbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar)
    }
}
