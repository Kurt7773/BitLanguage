package com.languagestudios.bitlanguagefinal

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.contentValuesOf
import kotlinx.android.synthetic.main.activity_pldape.*
import android.content.ContentValues
import android.content.Intent
import android.database.DatabaseUtils
import android.os.SystemClock
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_pldape.btnCheck
import kotlinx.android.synthetic.main.activity_pldape.btnContinue


public class PLDAPE : AppCompatActivity() {

//sound effects declaration
    var correctfx = MediaPlayer()
    var wrongfx = MediaPlayer()
    var btnfx = MediaPlayer()



//on back pressed
    override fun onBackPressed(){
        correctfx.stop()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pldape)

//Sound Effects main
        correctfx = MediaPlayer.create(this, R.raw.correctfx)
        wrongfx = MediaPlayer.create(this, R.raw.wrongfx)
        btnfx = MediaPlayer.create(this, R.raw.btnfx)
        if (correctfx.isPlaying != true) {
            //  music.start()
        }
        // music.isLooping = true

//Database Read
        var helper: MyDBHelper = MyDBHelper(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM Table1", null)

//Database Positition - Move item to last saved item
        var cv = ContentValues()
        var rs2 = db.rawQuery("SELECT * FROM POSITIONTABLE", null)
        var NoOfRows = DatabaseUtils.queryNumEntries(db, "POSITIONTABLE")
        if (NoOfRows == 0.toLong()) {
            cv.put("POSITION", 0)
            db.insert("POSITIONTABLE", null, cv)
            rs2.moveToLast()
        } else {
            rs2.moveToLast()
        }
        rs.moveToPosition(rs2.getInt(0))

//Display the items from the database
        txtQuestion.text = rs.getString(1)
        cb1.text = rs.getString(2)
        cb2.text = rs.getString(3)
        cb3.text = rs.getString(4)

//functions
        fun savepos() {
            rs.moveToNext()
            //insert position of items to position table
            cv.put("POSITION", rs.getInt(0))
            db.insert("POSITIONTABLE", null, cv)
            //
        }


        fun moveNext() {
            savepos()
            txtQuestion.text = rs.getString(1)
            cb1.text = rs.getString(2)
            cb2.text = rs.getString(3)
            cb3.text = rs.getString(4)
        }

        fun showcontinue() {
            correctfx.start()
            panel.isVisible = true
            greenflag.isVisible = true
            wintext.isVisible = true
            btnContinue.isVisible = true
            btnCheck.isVisible = false
        }

        fun showXcontinue() {
            wrongfx.start()
            panel.isVisible = true
            redflag.isVisible = true
            losetext.isVisible = true
            btnContinue.isVisible = true
            btnCheck.isVisible = false
            txtcorrectanswer.isVisible = true
            txtanswer.isVisible = true
            txtanswer.text = rs.getString(5)
        }

        fun hidecontinue() {
            panel.isVisible = false
            greenflag.isVisible = false
            wintext.isVisible = false
            btnContinue.isVisible = false
            btnCheck.isVisible = true
            redflag.isVisible = false
            losetext.isVisible = false
            txtcorrectanswer.isVisible = false
            txtanswer.isVisible = false
        }

        var flew = false
        fun flow() {
            if ((rs.getInt(0)+1) % 10 == 0 && rs.getInt(0) != 0) {
                flew = true
                savepos()
                val intent = Intent(this, PLDAPE3::class.java)
                startActivity(intent)
                hidecontinue()
            } else if ((rs.getInt(0)+1) % 5 == 0 && rs.getInt(0) != 0) {
                flew = true
                savepos()
                val intent = Intent(this, PLDAPE2::class.java)
                startActivity(intent)
                hidecontinue()
            }
        }

        var tutd = false
        fun tut(){
            if ((rs.getInt(0)+1)==5){
                tutd = true
                savepos()
                val intent = Intent(this, Tutorial::class.java)
                startActivity(intent)
            } else if ((rs.getInt(0)+1)==11){
                tutd = true
                savepos()
                val intent = Intent(this, Tutorial::class.java)
                startActivity(intent)
            }
        }


//Button Sound Effects
        cb1.setOnClickListener {
            btnfx.start()
        }

        cb2.setOnClickListener {
            btnfx.start()
        }

        cb3.setOnClickListener {
            btnfx.start()
        }


//MainCode
        hidecontinue()
        btnCheck.setOnClickListener {
            if (rs.getString(2) == rs.getString(5) && cb1.isChecked) {
                showcontinue()

            } else if (rs.getString(3) == rs.getString(5) && cb2.isChecked) {
                showcontinue()

            } else if (rs.getString(4) == rs.getString(5) && cb3.isChecked) {
                showcontinue()

            } else {
                showXcontinue()
            }
            RadioGroup.clearCheck()
        }

        btnContinue.setOnClickListener {
            tut()
            if (tutd == true){
                tutd=false
            } else {
                flow()
                if (flew == false){
                    hidecontinue()
                    moveNext()
                } else {
                    flew = false
                }
            }





        }



    }
}