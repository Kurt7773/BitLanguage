package com.languagestudios.bitlanguagefinal

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_database_edit.*
import kotlinx.android.synthetic.main.activity_database_edit.view.*
import kotlinx.android.synthetic.main.activity_main.*


class DatabaseEdit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database_edit)

        var helper: MyDBHelper = MyDBHelper(applicationContext)

        btnAddData.setOnClickListener{
            var db = helper.readableDatabase
            var cv = ContentValues()
            cv.put("ITEMNUMBER", txtNumber.text.toString().toInt())
            cv.put("QUESTION", txtQuestion.text.toString())
            cv.put("ITEM1", txtCb1.text.toString())
            cv.put("ITEM2", txtCb2.text.toString())
            cv.put("ITEM3", txtCb3.text.toString())
            cv.put("ANSWER", txtAnswer.text.toString())
            db.insert("Table1",null,cv)

            Toast.makeText(this, "Added Successfuly", Toast.LENGTH_SHORT).show()

            txtNumber.text.clear()
            txtQuestion.text.clear()
            txtCb1.text.clear()
            txtCb2.text.clear()
            txtCb3.text.clear()
            txtAnswer.text.clear()
        }

        btnDeleteData.setOnClickListener{
            var db = helper.writableDatabase
            db.delete("Table1", "ITEMNUMBER"+"=?", arrayOf(txtNumberDelete.toString()))

        }

        btnShowLatestData.setOnClickListener{
            var db = helper.readableDatabase
            var rs = db.rawQuery("SELECT * FROM Table1", null)
            if (rs.moveToNext()) {
                rs.moveToLast()
                Toast.makeText(applicationContext, rs.getString(1), Toast.LENGTH_SHORT).show()
            }
        }


    }
}