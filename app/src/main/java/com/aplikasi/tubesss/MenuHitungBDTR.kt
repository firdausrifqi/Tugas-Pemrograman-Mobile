@file:Suppress("DEPRECATION")

package com.aplikasi.tubesss

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.aplikasi.tubesss.optionmenu.MyThemStatus

class MenuHitungBDTR : AppCompatActivity() {
    lateinit var tvPsg: TextView
    lateinit var tvLngkrn: TextView
    lateinit var tvPsgPjg: TextView
    lateinit var tvSgtg: TextView
    lateinit var tvTrpsm: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_hitung_b_d_t_r)
        checkTheme()
        setTitle("List Bangun Datar")
        tvPsg = findViewById<Button>(R.id.BtnPersegi)
        tvLngkrn = findViewById<Button>(R.id.BtnLingkaran)
        tvPsgPjg = findViewById<Button>(R.id.BtnKel)
        tvSgtg = findViewById<Button>(R.id.BtnSegitiga)
        tvTrpsm = findViewById<Button>(R.id.BtnTrapesium)

        tvPsg.setOnClickListener(View.OnClickListener {
            val j = Intent(this, MenghitungPersegi::class.java)
            startActivity(j)
        })
        tvLngkrn.setOnClickListener(View.OnClickListener {
            val j = Intent(this, MenghitungLingkrn::class.java)
            startActivity(j)
        })
        tvPsgPjg.setOnClickListener(View.OnClickListener {
            val j = Intent(this, MenghitungPsgPjg::class.java)
            startActivity(j)
        })
        tvSgtg.setOnClickListener(View.OnClickListener {
            val j = Intent(this, MenghitungSgtg::class.java)
            startActivity(j) })
        tvTrpsm.setOnClickListener(View.OnClickListener {
            val j = Intent(this, MenghitungTrpsm::class.java)
            startActivity(j)
        })
    }
    private fun checkTheme() {
        var linear = findViewById<LinearLayout>(R.id.LinearBDTR)
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