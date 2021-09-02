@file:Suppress("DEPRECATION")

package com.aplikasi.tubesss.optionmenu

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.aplikasi.tubesss.MenuHitungBDTR
import com.aplikasi.tubesss.R
import com.aplikasi.tubesss.R.*
import com.aplikasi.tubesss.WeatherApps

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_setting2)
        checkTheme()
        var settingbtn = findViewById<Button>(id.settingbtn)
        var Aboutbtn = findViewById<Button>(id.aboutbtn)
        var helpbtn = findViewById<Button>(id.helpbtn)
        setTitle("OPTION")
        settingbtn.setOnClickListener(View.OnClickListener {
            val i = Intent(this, Setting::class.java)
            startActivity(i)
        })

         Aboutbtn.setOnClickListener(View.OnClickListener {
            val j = Intent(this, AboutActivity::class.java)
            startActivity(j)
        })

        helpbtn.setOnClickListener(View.OnClickListener {
            val j = Intent(this, HelpActivity::class.java)
            startActivity(j)
        })


    }
    private fun checkTheme() {
        var linear = findViewById<LinearLayout>(R.id.LinearIDs)
        when (MyThemStatus(this).darkMode) {
            0 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

                delegate.applyDayNight()
                linear.setBackgroundColor(resources.getColor(R.color.teal_700))
            }
            1 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                setTheme(style.Darktheme)
                delegate.applyDayNight()
            }
        }
    }
}


