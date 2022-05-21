package com.languagestudios.bitlanguagefinal

import android.content.ContentValues
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_pldape.*
import kotlinx.android.synthetic.main.activity_pldape2.*
import kotlinx.android.synthetic.main.activity_pldape2.btnCheck
import kotlinx.android.synthetic.main.activity_pldape2.btnContinue
import kotlinx.android.synthetic.main.activity_pldape2.greenflag2
import kotlinx.android.synthetic.main.activity_pldape2.panel2
import kotlinx.android.synthetic.main.activity_pldape2.wintext2

class PLDAPE2 : AppCompatActivity() {


//Sound Effects declaration
    var correctfx = MediaPlayer()
    var wrongfx = MediaPlayer()
    var btnfx = MediaPlayer()
    var music = MediaPlayer()

//on back pressed
    override fun onBackPressed(){
        music.stop()
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pldape2)

//sound effects main
        correctfx = MediaPlayer.create(this, R.raw.correctfx)
        wrongfx = MediaPlayer.create(this, R.raw.wrongfx)
        btnfx = MediaPlayer.create(this, R.raw.btnfx)

//database access
        var helper: MyDBHelper = MyDBHelper(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM Table1", null)
        var rs2 = db.rawQuery("SELECT * FROM POSITIONTABLE", null)
        rs2.moveToLast()
        rs.moveToPosition(rs2.getInt(0))
        var background = getResources().getIdentifier(rs.getString(2), "drawable", packageName)
        var pos = rs.getInt(0)

//set background
        flowchartlayout.setBackgroundResource(background)


//radio button
        Fcb1.setOnClickListener{
            btnfx.start()
            Fcb2.isChecked = false
            Fcb3.isChecked = false
            Fcb4.isChecked = false
        }
        Fcb2.setOnClickListener{
            btnfx.start()
            Fcb1.isChecked = false
            Fcb3.isChecked = false
            Fcb4.isChecked = false
        }
        Fcb3.setOnClickListener{
            btnfx.start()
            Fcb2.isChecked = false
            Fcb1.isChecked = false
            Fcb4.isChecked = false
        }
        Fcb4.setOnClickListener{
            btnfx.start()
            Fcb2.isChecked = false
            Fcb3.isChecked = false
            Fcb1.isChecked = false
        }

//methods
        fun showcontinue() {
            correctfx.start()
            panel2.isVisible = true
            greenflag2.isVisible = true
            wintext2.isVisible = true
            btnContinue.isVisible = true
            btnCheck.isVisible = false
        }

        fun showXcontinue() {
            wrongfx.start()
            panel2.isVisible = true
            redflag2.isVisible = true
            losetext2.isVisible = true
            btnContinue.isVisible = true
            btnCheck.isVisible = false
        }

        fun hidecontinue() {
            panel2.isVisible = false
            greenflag2.isVisible = false
            wintext2.isVisible = false
            btnContinue.isVisible = false
            btnCheck.isVisible = true
            redflag2.isVisible = false
            losetext2.isVisible = false
        }

//maincode
        hidecontinue()
        btnCheck.setOnClickListener{
            var answer = ""
            if (Fcb1.isChecked == true){
                answer = "Fcb1"
            } else if (Fcb2.isChecked == true){
                answer = "Fcb2"
            } else if (Fcb3.isChecked == true){
                answer = "Fcb3"
            } else if (Fcb4.isChecked == true){
                answer = "Fcb4"
            }

            if (answer == rs.getString(5)){
                showcontinue()
            } else {
                showXcontinue()
            }
        }

        btnContinue.setOnClickListener{
            if ((rs.getInt(0)+1) == 16) {
                var cv = ContentValues()
                cv.put("POSITION", rs.getInt(0))
                db.insert("POSITIONTABLE",null,cv)
                val intent = Intent(this, Tutorial::class.java)
                startActivity(intent)
                rs.moveToNext()
            } else if ((rs.getInt(0)+1) == 26) {
                var cv = ContentValues()
                cv.put("POSITION", rs.getInt(0))
                db.insert("POSITIONTABLE",null,cv)
                val intent = Intent(this, Tutorial::class.java)
                startActivity(intent)
                rs.moveToNext()
            } else {
                rs.moveToNext()
                var cv = ContentValues()
                cv.put("POSITION", rs.getInt(0))
                db.insert("POSITIONTABLE", null, cv)
                //
                hidecontinue()
                val intent = Intent(this, PLDAPE::class.java)
                startActivity(intent)
            }
        }




    }
}