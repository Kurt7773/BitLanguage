package com.languagestudios.bitlanguagefinal

import android.content.ContentValues
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.contentValuesOf
import kotlinx.android.synthetic.main.activity_tutorial.*


class Tutorial : AppCompatActivity() {

//on back pressed
    override fun onBackPressed(){
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

//Music Declaration
        var btnfx = MediaPlayer()
        btnfx = MediaPlayer.create(this, R.raw.btnfx)


//Database Access
        var helper: MyDBHelper = MyDBHelper(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM Table1", null)
        var rs2 = db.rawQuery("SELECT * FROM POSITIONTABLE", null)
        rs2.moveToLast()
        rs.moveToPosition(rs2.getInt(0))
        var cv = ContentValues()
        var pos = rs.getString(0).toInt()


        var background1 = getResources().getIdentifier("t1", "drawable", packageName)
        var background2 = getResources().getIdentifier("t2", "drawable", packageName)
        var background3 = getResources().getIdentifier("t3", "drawable", packageName)
        var background4 = getResources().getIdentifier("t4", "drawable", packageName)
        var background5 = getResources().getIdentifier("t5", "drawable", packageName)
        var background6 = getResources().getIdentifier("t6", "drawable", packageName)
        var background7 = getResources().getIdentifier("t7", "drawable", packageName)
        var background8 = getResources().getIdentifier("t8", "drawable", packageName)
        var backgroundfinish = getResources().getIdentifier("tfinish", "drawable", packageName)



//Main code
        if (pos==0){
            TutorialLayout.setBackgroundResource(background1)
        } else if (pos == 5){
            TutorialLayout.setBackgroundResource(background3)
        } else if (pos == 11){
            TutorialLayout.setBackgroundResource(background4)
        } else if (pos == 15){
            TutorialLayout.setBackgroundResource(background5)
        } else if (pos == 25){
            TutorialLayout.setBackgroundResource(background6)
        } else if (pos == 31){
            TutorialLayout.setBackgroundResource(background7)
        } else if (pos == 41){
            TutorialLayout.setBackgroundResource(background8)
        }else if (pos == 51){
            TutorialLayout.setBackgroundResource(backgroundfinish)
        }else {
            TutorialLayout.setBackgroundResource(background1)
        }


        var bg1 = false

        btnContinue.setOnClickListener{
            btnfx.start()
            if (pos==0 && bg1 == false){
                TutorialLayout.setBackgroundResource(background2)
                bg1 = true
            } else if(pos == 5) {
                val intent = Intent(this, PLDAPE2::class.java)
                startActivity(intent)
            } else if(pos == 15){
                rs.moveToNext()
                //insert position of items to position table
                cv.put("POSITION", rs.getInt(0))
                db.insert("POSITIONTABLE", null, cv)
                //
                val intent = Intent(this, PLDAPE::class.java)
                startActivity(intent)
            }else if(pos == 25){
                rs.moveToNext()
                //insert position of items to position table
                cv.put("POSITION", rs.getInt(0))
                db.insert("POSITIONTABLE", null, cv)
                //
                val intent = Intent(this, PLDAPE::class.java)
                startActivity(intent)
            }else if(pos == 51){
                rs.moveToNext()
                //insert position of items to position table
                cv.put("POSITION", rs.getInt(0))
                db.insert("POSITIONTABLE", null, cv)
                //
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                val intent = Intent(this, PLDAPE::class.java)
                startActivity(intent)
            }
        }


    }
}