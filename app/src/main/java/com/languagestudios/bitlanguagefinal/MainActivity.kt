package com.languagestudios.bitlanguagefinal

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.content.contentValuesOf
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart.setOnClickListener{
            Toast.makeText(this,"Let's Go!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, PLDAPE::class.java)
            startActivity(intent)
        }


        btnDatabase.isVisible = false
        btnDatabase.setOnClickListener{
            val intent = Intent(this, DatabaseEdit::class.java)
            startActivity(intent)
        }













    }
}