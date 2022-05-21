package com.languagestudios.bitlanguagefinal

import android.content.ContentValues
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_pldape.*
import kotlinx.android.synthetic.main.activity_pldape3.*
import kotlinx.android.synthetic.main.activity_pldape3.btnCheck
import kotlinx.android.synthetic.main.activity_pldape3.btnContinue
import kotlinx.android.synthetic.main.activity_pldape3.greenflag
import kotlinx.android.synthetic.main.activity_pldape3.losetext
import kotlinx.android.synthetic.main.activity_pldape3.panel
import kotlinx.android.synthetic.main.activity_pldape3.redflag
import kotlinx.android.synthetic.main.activity_pldape3.txtanswer
import kotlinx.android.synthetic.main.activity_pldape3.txtcorrectanswer
import kotlinx.android.synthetic.main.activity_pldape3.wintext


class PLDAPE3 : AppCompatActivity() {

//on back pressed
    override fun onBackPressed(){
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

//music declaration
    var correctfx = MediaPlayer()
    var wrongfx = MediaPlayer()
    var btnfx = MediaPlayer()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pldape3)

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




//functions
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




//set background
        codelayout.setBackgroundResource(background)



//main code
        hidecontinue()

        btnCheck.setOnClickListener{
            if(rs.getString(5).toString()==editText.text.toString()){
                showcontinue()
            }else{
                showXcontinue()
            }
        }

        btnContinue.setOnClickListener{
            if(rs.getInt(0)%10==0 &&rs.getInt(0) != 20 && rs.getInt(0) != 21){
                rs.moveToNext()
                //insert position of items to position table
                var cv = ContentValues()
                cv.put("POSITION", rs.getInt(0))
                db.insert("POSITIONTABLE",null,cv)
                //
                val intent = Intent(this, Tutorial::class.java)
                startActivity(intent)
            } else {
                //insert position of items to position table
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