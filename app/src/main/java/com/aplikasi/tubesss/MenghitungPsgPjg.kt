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

class MenghitungPsgPjg : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menghitung_psg_pjg)
        checkTheme()
        setTitle("Menghitung Bangun Datar")
        var luas = findViewById<EditText>(R.id.InputAB)
        var kel = findViewById<EditText>(R.id.InputAE)
        var btnLuas = findViewById<Button>(R.id.BtnLuas)
        var tvHsl = findViewById<TextView>(R.id.HasilOutput)
        var btnKel = findViewById<Button>(R.id.BtnKel)
        btnLuas.setOnClickListener(View.OnClickListener {
            var p = luas.text.toString()
            var l = kel.text.toString()
            if (p.isNullOrEmpty() || l.isNullOrEmpty()){
                tvHsl.setText("Nilai P dan L Tidak Boleh Kosong")
            }
            else{
                var P = p.toDouble()
                var L = l.toDouble()
                var hsl = P * L
                tvHsl.setText(" Luas Persegi Panjang dengan \n panjang : " + p + " dan lebar: " + l + " adalah:\n" + hsl.toString())
            }
        })
        btnKel.setOnClickListener(View.OnClickListener {
            var p = luas.text.toString()
            var l = kel.text.toString()
            if (p.isNullOrEmpty() || l.isNullOrEmpty()){
                tvHsl.setText("Nilai P dan L Tidak Boleh Kosong")
            }
            else{
                var P = p.toDouble()
                var L = l.toDouble()
                var hsl = 2 * (P + L)
                tvHsl.setText("Keliling Persegi Panjang dengan \n panjang : $p dan lebar: $l adalah: \n ${hsl.toString()} ")
            }
        })
    }
    private fun checkTheme() {
        var linear = findViewById<LinearLayout>(R.id.psgpjgiid)
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