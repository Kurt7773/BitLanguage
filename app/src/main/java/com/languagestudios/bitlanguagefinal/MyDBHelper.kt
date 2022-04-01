package com.languagestudios.bitlanguagefinal

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper (context:Context): SQLiteOpenHelper(context, "ITEMS", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE Table1 (ITEMNUMBER INTEGER PRIMARY KEY AUTOINCREMENT, QUESTION TEXT, ITEM1 TEXT, ITEM2 TEXT, ITEM3 TEXT, ANSWER TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("CREATE TABLE Table1 (ITEMNUMBER INTEGER PRIMARY KEY, QUESTION TEXT, ITEM1 TEXT, ITEM2 TEXT, ITEM3 TEXT, ANSWER TEXT)")

    }



}