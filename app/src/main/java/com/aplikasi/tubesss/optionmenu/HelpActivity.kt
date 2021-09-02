@file:Suppress("DEPRECATION")

package com.aplikasi.tubesss.optionmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.aplikasi.tubesss.R

class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
        checkTheme()
        setTitle("Help")
        val textView = findViewById<TextView>(R.id.textView)
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
    private fun checkTheme() {
        var linear = findViewById<LinearLayout>(R.id.HelpID)
        when (MyThemStatus(this).darkMode) {
            0 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                delegate.applyDayNight()
                linear.setBackgroundColor(resources.getColor(R.color.bgrhitpers))
            }
            1 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                delegate.applyDayNight()
            }
        }
    }
}