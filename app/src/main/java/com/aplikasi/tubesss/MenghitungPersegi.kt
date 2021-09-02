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

class MenghitungPersegi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menghitung_persegi)
        checkTheme()
        setTitle("Menghitung Bangun Datar")
        var esHtgluas = findViewById<EditText>(R.id.inputR)
        var bttnHsl = findViewById<Button>(R.id.BtnLuas)
        var tvHsl = findViewById<TextView>(R.id.HasilOutput)
        var bttnHsl2 = findViewById<Button>(R.id.BtnKel)
        bttnHsl.setOnClickListener(View.OnClickListener {
            var sisi = esHtgluas.text.toString()
            if (sisi.isNullOrEmpty()){
                tvHsl.setText("Nilai Sisi Tidak Boleh Kosong")
            }
            else {
                var ss = sisi.toDouble()
                var hsl = ss * ss
                tvHsl.setText("Luas Persegi dengan sisi :" + sisi + " \n adalah : " + hsl.toString())
            }
        })
        bttnHsl2.setOnClickListener(View.OnClickListener {
            var sisiStr = esHtgluas.getText().toString()
            if (sisiStr.isNullOrEmpty()){
                tvHsl.setText("Nilai Sisi Tidak Boleh Kosong")
            }
            else{
                var sisi = sisiStr.toDouble()
                var hsl = sisi+sisi+sisi+sisi
                tvHsl.setText("Keliling Persegi dengan sisi: $sisi adalah: $hsl")
            }
        })

    }
    private fun checkTheme() {
        var linear = findViewById<LinearLayout>(R.id.persegiID)
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