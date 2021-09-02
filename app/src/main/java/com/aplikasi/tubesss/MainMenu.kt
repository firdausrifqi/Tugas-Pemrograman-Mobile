@file:Suppress("DEPRECATION")

package com.aplikasi.tubesss

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.aplikasi.tubesss.optionmenu.MyThemStatus
import com.aplikasi.tubesss.optionmenu.SettingActivity

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        checkTheme()
        var weatherbtn = findViewById<Button>(R.id.weatherbtn)
        var calculatorbtn = findViewById<Button>(R.id.calculatorbtn)
        var notebtn = findViewById<Button>(R.id.notebtn)
        setTitle("MainMenu")
        weatherbtn.setOnClickListener(View.OnClickListener {
            val i = Intent(this, WeatherApps::class.java)
            startActivity(i)
        })

        calculatorbtn.setOnClickListener(View.OnClickListener {
            val j = Intent(this, MenuHitungBDTR::class.java)
            startActivity(j)
        })

        notebtn.setOnClickListener(View.OnClickListener {
            val j = Intent(this, SettingActivity::class.java)
            startActivity(j)
        })
    }
    private fun checkTheme() {
        var  linear = findViewById<LinearLayout>(R.id.LinearID)
        when (MyThemStatus(this).darkMode) {
            0 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                delegate.applyDayNight()
                linear.setBackgroundColor(resources.getColor(R.color.teal_700))
            }
            1 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                delegate.applyDayNight()
            }
        }
    }
}