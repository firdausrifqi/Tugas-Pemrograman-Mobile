package com.aplikasi.tubesss

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.aplikasi.tubesss.optionmenu.MyThemStatus

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkTheme()
        setTitle("")
        var bKirim = findViewById<Button>(R.id.btnok)
        var edNama = findViewById<EditText>(R.id.editUN)
        var edPass = findViewById<EditText>(R.id.editPass)
        bKirim.setOnClickListener(View.OnClickListener {
            var user = edNama.text.toString()
            var pass = edPass.text.toString()
            if (pass == "123" && user == "admin") {
                Toast.makeText(this, "Login Sukses", Toast.LENGTH_LONG).show()
                val i = Intent(this, MainMenu::class.java)
                startActivity(i)
            } else {
                Toast.makeText(this, "password salah", Toast.LENGTH_LONG).show()
            }
        })
    }
    private fun checkTheme() {
        var edNama = findViewById<EditText>(R.id.editUN)
        var edPass = findViewById<EditText>(R.id.editPass)
        var title = findViewById<TextView>(R.id.titletext)
        when (MyThemStatus(this).darkMode) {
            0 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                setTheme(R.style.Theme_Tubesss)
                edNama.setTextColor(Color.BLACK)
                edPass.setTextColor(Color.BLACK)
                delegate.applyDayNight()
            }
            1 -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                edNama.setTextColor(Color.WHITE)
                title.setTextColor(Color.CYAN)
                edPass.setTextColor(Color.WHITE)
                setTheme(R.style.Darktheme)
                delegate.applyDayNight()
            }
        }
    }

}