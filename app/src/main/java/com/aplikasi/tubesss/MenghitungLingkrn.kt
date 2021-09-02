package com.aplikasi.tubesss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.aplikasi.tubesss.optionmenu.MyThemStatus

class MenghitungLingkrn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menghitung_lingkrn)
        checkTheme()
        setTitle("Menghitung Bangun Datar")
        var esHtgluas = findViewById<EditText>(R.id.inputR)
        var btnLuas = findViewById<Button>(R.id.BtnLuas)
        var btnkel = findViewById<Button>(R.id.BtnKel)
        var tvHsl = findViewById<TextView>(R.id.HasilOutput)
        btnLuas.setOnClickListener(View.OnClickListener {
            var r = esHtgluas.text.toString()
            if (r.isNullOrEmpty()){
                tvHsl.setText("Nilai R Tidak Boleh Kosong ")
            }
            else{
                var R = r.toDouble()
                var phi = 3.14
                var hsl = 2 * phi * R
                tvHsl.setText("Luas Lingkaran dengan jari-jari: $r \n adalah: $hsl")
            }
        })
        btnkel.setOnClickListener(View.OnClickListener {
            var r = esHtgluas.text.toString()
            if (r.isNullOrEmpty()){
                tvHsl.setText("Nilai R Tidak Boleh Kosong ")
            }
            else{
                var R = r.toDouble()
                var phi = 3.14
                var hsl = phi * (R * R)
                tvHsl.setText("Keliling Lingkaran dengan jari -jari:" + r + "\n adalah: " + hsl.toString())
            }
        })
    }
    private fun checkTheme() {
        var linear = findViewById<LinearLayout>(R.id.LngkrnID)
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