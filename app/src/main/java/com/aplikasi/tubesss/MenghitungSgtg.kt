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

class MenghitungSgtg : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menghitung_sgtg)
        checkTheme()
        setTitle("Menghitung Bangun Datar")
        var edA = findViewById<EditText>(R.id.InputA)
        var edT = findViewById<EditText>(R.id.InputT)
        var edssm = findViewById<EditText>(R.id.inputSSM)
        var btnkel = findViewById<Button>(R.id.BtnKel)
        var btnluas = findViewById<Button>(R.id.BtnLuas)
        var tvHsl = findViewById<TextView>(R.id.HasilOutput)
        btnkel.setOnClickListener(View.OnClickListener {
            var a = edA.text.toString()
            var t = edT.text.toString()
            var ssm = edssm.text.toString()
            if (a.isNullOrEmpty() || t.isNullOrEmpty() || ssm.isNullOrEmpty()){
                tvHsl.setText("Nilai A, T dan SSM Tidak boleh kosong")
            }
            else{
                var SisiMiring = ssm.toDouble()
                var alas = a.toDouble()
                var tinggi = t.toDouble()
                var hsl = SisiMiring + alas + tinggi
                tvHsl.setText("Keliling Segitiga dengan \n alas : " + a + ", tinggi: " + t + " dan sisi miring: " + ssm + "\n adalah: " + hsl.toString())
            }
        })
        btnluas.setOnClickListener(View.OnClickListener {
            var a = edA.text.toString()
            var t = edT.text.toString()
            if (a.isNullOrEmpty() || t.isNullOrEmpty()){
                tvHsl.setText("Nilai A, dan T Tidak boleh kosong")
            }
            else{
                var A = a.toDouble()
                var T = t.toDouble()
                var hsl = (A * T) / 2
                tvHsl.setText("Luas Segitiga dengan \n alas : " + a + " dan tinggi: " + t + " adalah:\n" + hsl.toString())
            }
        })
    }
    private fun checkTheme() {
        var linear = findViewById<LinearLayout>(R.id.sgtgid)
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