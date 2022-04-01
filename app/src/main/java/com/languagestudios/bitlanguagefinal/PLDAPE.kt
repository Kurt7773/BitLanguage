package com.languagestudios.bitlanguagefinal

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_pldape.*

class PLDAPE : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pldape)

        var music = MediaPlayer()
        music = MediaPlayer.create(this, R.raw.wordscape)
        music.start()
        music.isLooping = true

        var life = 5
        var helper: MyDBHelper = MyDBHelper(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM Table1", null)

        txtLife.text = life.toString()
        rs.moveToPosition(0)

        txtQuestion.text=rs.getString(1)
        cb1.text=rs.getString(2)
        cb2.text=rs.getString(3)
        cb3.text=rs.getString(4)

        fun moveNext(){
            rs.moveToNext()
            txtQuestion.text=rs.getString(1)
            cb1.text=rs.getString(2)
            cb2.text=rs.getString(3)
            cb3.text=rs.getString(4)
            txtLife.text = life.toString()
        }

        btnCheck.setOnClickListener{
            if(rs.getString(2)==rs.getString(5) && cb1.isChecked){
                moveNext()
            } else if (rs.getString(3)==rs.getString(5) && cb2.isChecked){
                moveNext()
            } else if (rs.getString(4)==rs.getString(5) && cb3.isChecked){
                moveNext()
            } else {
                Toast.makeText(this,"Try Again", Toast.LENGTH_SHORT).show()
                life--
                txtLife.text = life.toString()

            }
            RadioGroup.clearCheck()
        }

    }
}