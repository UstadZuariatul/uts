package com.example.zuritauluts

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.zuritauluts.fragment.UntukmuFragment

class DetailKomikActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_komik_activity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val komik = intent.getParcelableExtra<Komik>(UntukmuFragment.INTENT_PARCELABLE)

        val imgDetail = findViewById<ImageView>(R.id.ivPhoto)
        val nameKomik = findViewById<TextView>(R.id.tvJudul)
//        val descKomik = findViewById<TextView>(R.id.tvDesc)

        imgDetail.setImageResource(komik?.imgDetail!!)
        nameKomik.text = komik.nameKomik
//        descKomik.text = komik.descKomik
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}