package com.aplikasi.tubesss.optionmenu

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.constraintlayout.widget.ConstraintLayout
import com.aplikasi.tubesss.R


class Setting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        checkTheme()
        var statusmode: Boolean;
        val modebtn = findViewById<Button>(R.id.ModeBtn);
        var title = findViewById<TextView>(R.id.TitleText);
        var Type = findViewById<TextView>(R.id.TypeText);
        statusmode = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES;
        if (statusmode){
            title.setTextColor(Color.WHITE)
            Type.setTextColor(Color.WHITE)
            modebtn.setBackgroundColor(Color.GREEN)
            modebtn.text = "ON";
        }
        else{
            title.setTextColor(Color.WHITE)
            Type.setTextColor(Color.WHITE)
            modebtn.setBackgroundColor(Color.RED)
            modebtn.text = "OFF";
        }
        modebtn.setOnClickListener(View.OnClickListener {
            if(statusmode){
                statusmode = false
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                MyThemStatus(this).darkMode = 0
                delegate.applyDayNight()
                Toast.makeText(this, "DARKMODE OFF", Toast.LENGTH_LONG).show()
            }
            else {
                statusmode = true
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                MyThemStatus(this).darkMode = 1
                delegate.applyDayNight()
                Toast.makeText(this, "DARKMODE ON", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun checkTheme() {
        var linear = findViewById<ConstraintLayout>(R.id.SettingID)
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