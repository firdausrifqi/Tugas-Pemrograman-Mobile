@file:Suppress("DEPRECATION")

package com.aplikasi.tubesss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.aplikasi.tubesss.optionmenu.MyThemStatus
import java.lang.Double.parseDouble

class MenghitungTrpsm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menghitung_trpsm)
        checkTheme()
        setTitle("Menghitung Bangun Datar")
        var edAB = findViewById<EditText>(R.id.InputAB)
        var edEF = findViewById<EditText>(R.id.inputEF)
        var edAE = findViewById<EditText>(R.id.InputAE)
        var edt = findViewById<EditText>(R.id.inputT)
        var btnluas = findViewById<Button>(R.id.BtnLuas)
        var btnkel = findViewById<Button>(R.id.BtnKel)
        var tvHsl = findViewById<TextView>(R.id.HasilOutput)
        btnkel.setOnClickListener(View.OnClickListener {
            var nAB = edAB.text.toString()
            var nAE = edAE.text.toString()
            var nEF = edEF.text.toString()
            if (nAB.isNullOrEmpty() || nAE.isNullOrEmpty() || nEF.isNullOrEmpty()){
                tvHsl.setText("Nilai AB, EF dan AE Tidak boleh kosong")
            }
            else{
                var ab = nAB.toDouble()
                var ae = nAE.toDouble()
                var ef = nEF.toDouble()
                var hsl = (ab + ef + ae) * 2
                tvHsl.setText("Keliling Trapesium dengan panjang AB: " + nAB + ", panjang EF: " + nEF + " dan\n AE: " + nAE + " adalah: " + hsl.toString())
            }
        })

        btnluas.setOnClickListener(View.OnClickListener {
            var nAB = edAB.text.toString()
            var nT = edt.text.toString()
            var nEF = edEF.text.toString()
            if (nAB.isNullOrEmpty() || nT.isNullOrEmpty() || nEF.isNullOrEmpty()){
                tvHsl.setText("Masukkan Nilai AB, EF dan T Dengan Angka")
            }
            else{
                var ab = nAB.toDouble()
                var t = nT.toDouble()
                var ef = nEF.toDouble()
                var hsl = (ab + ef) * t / 2
                tvHsl.setText("Luas Trapesium dengan panjang\nAB: " + nAB + " , panjang EF: " + nEF + " dan\n tinggi: " + nT + " adalah: " + hsl.toString())
            }
        })
    }
    private fun checkTheme() {
        var linear = findViewById<LinearLayout>(R.id.trpsmid)
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