package com.languagestudios.bitlanguagefinal

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.DatabaseUtils
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.core.content.contentValuesOf
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_database_edit.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//btnfx declaration
    var btnfx = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//Sound Effects
        btnfx = MediaPlayer.create(this, R.raw.btnfx)


//database helper
        var helper: MyDBHelper = MyDBHelper(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM Table1", null)
        var item = Array<String>(500, { _ -> "" })
        var question = Array<String>(500, { _ -> "" })
        var cb1 = Array<String>(500, { _ -> "" })
        var cb2 = Array<String>(500, { _ -> "" })
        var cb3 = Array<String>(500, { _ -> "" })
        var answer = Array<String>(500, { _ -> "" })
        var rs2 = db.rawQuery("SELECT * FROM POSITIONTABLE", null)

//layout
        var NoOfRows = DatabaseUtils.queryNumEntries(db,"POSITIONTABLE")
        if(NoOfRows == 0.toLong()){
            btnContinue.isVisible = false
        }

//Start
        btnStart.setOnClickListener{
            btnfx.start()
            var cv2 = ContentValues()
            cv2.put("POSITION", 0)
            db.insert("POSITIONTABLE",null,cv2)
            val intent = Intent(this, Tutorial::class.java)
            startActivity(intent)
        }


//Continue
        btnContinue.setOnClickListener{
            rs2.moveToLast()
            if (rs2.getInt(0)%10==0){
                val intent = Intent(this, PLDAPE3::class.java)
                startActivity(intent)
            }else if (rs2.getInt(0)%5==0){
                val intent = Intent(this, PLDAPE2::class.java)
                startActivity(intent)
            }else{
                val intent = Intent(this, PLDAPE::class.java)
                startActivity(intent)
            }
        }


        btnDatabase.isVisible = false
        btnDatabase.setOnClickListener{
            val intent = Intent(this, DatabaseEdit::class.java)
            startActivity(intent)
        }


//Lessons
        btnlesson1.setOnClickListener{
            btnStart.performClick()
        }
        btnlesson2.setOnClickListener{
            btnfx.start()
            var cv2 = ContentValues()
            cv2.put("POSITION", 11)
            db.insert("POSITIONTABLE",null,cv2)
            val intent = Intent(this, Tutorial::class.java)
            startActivity(intent)
        }
        btnlesson3.setOnClickListener{
            btnfx.start()
            var cv2 = ContentValues()
            cv2.put("POSITION", 15)
            db.insert("POSITIONTABLE",null,cv2)
            val intent = Intent(this, Tutorial::class.java)
            startActivity(intent)
        }
        btnlesson4.setOnClickListener{
            btnfx.start()
            var cv2 = ContentValues()
            cv2.put("POSITION", 25)
            db.insert("POSITIONTABLE",null,cv2)
            val intent = Intent(this, Tutorial::class.java)
            startActivity(intent)
        }
        btnlesson5.setOnClickListener{
            btnfx.start()
            var cv2 = ContentValues()
            cv2.put("POSITION", 31)
            db.insert("POSITIONTABLE",null,cv2)
            val intent = Intent(this, Tutorial::class.java)
            startActivity(intent)
        }
        btnlesson6.setOnClickListener{
            btnfx.start()
            var cv2 = ContentValues()
            cv2.put("POSITION", 41)
            db.insert("POSITIONTABLE",null,cv2)
            val intent = Intent(this, Tutorial::class.java)
            startActivity(intent)
        }



//items
        item[0] = "0"
        item[1] = "1"
        item[2] = "2"
        item[3] = "3"
        item[4] = "4"
        item[5] = "5"
        item[6] = "6"
        item[7] = "7"
        item[8] = "8"
        item[9] = "9"
        item[10] = "10"
        item[11] = "11"
        item[12] = "12"
        item[13] = "13"
        item[14] = "14"
        item[15] = "15"
        item[16] = "16"
        item[17] = "17"
        item[18] = "18"
        item[19] = "19"
        item[20] = "20"
        item[21] = "21"
        item[22] = "22"
        item[23] = "23"
        item[24] = "24"
        item[25] = "25"
        item[26] = "26"
        item[27] = "27"
        item[28] = "28"
        item[29] = "29"
        item[30] = "30"
        item[31] = "31"
        item[32] = "32"
        item[33] = "33"
        item[34] = "34"
        item[35] = "35"
        item[36] = "37"
        item[37] = "47"
        item[38] = "48"
        item[39] = "49"
        item[40] = "40"
        item[41] = "41"
        item[42] = "42"
        item[43] = "43"
        item[44] = "44"
        item[45] = "45"
        item[46] = "46"
        item[47] = "47"
        item[48] = "48"
        item[49] = "49"
        item[50] = "50"
        item[51] = "51"
        item[52] = "52"
        item[53] = "53"
        item[54] = "54"
        item[55] = "55"
        item[56] = "56"
        item[57] = "57"
        item[58] = "58"
        item[59] = "59"
        item[60] = "60"
        item[61] = "61"
        item[62] = "62"
        item[63] = "63"
        item[64] = "64"
        item[65] = "65"
        item[66] = "66"
        item[67] = "67"
        item[68] = "68"
        item[69] = "69"
        item[70] = "70"



        //questions
        question[0] = "What is a correct syntax to output Hello World in Java?"
        question[1] = "What is missing? \nSystem.out.println(“Hello World”)"
        question[2] = "What method houses all the code to be executed? "
        question[3] = "What is missing? \nSystem.out.println”Hello World”;"
        question[4] = "What is missing? \nSystem.___.println(“Hello World”);"
        question[5] = ""
        question[6] = "What is \"ln\" in System.out.println?"
        question[7] = "What is the output? \nSystem.out.println(“Hello\\nWorld”);"
        question[8] = "What is the output? \nSystem.out.println(“Cat”);"
        question[9] = "What is the output? \nSystem.out.println(7);"
        question[10] = ""
        question[11] = "Which of the choices is a code for a java comments?"
        question[12] = "What is the use of comments?"
        question[13] = "How many lines of code does this comment counts:\n//"
        question[14] = "Which of these is a multi-line comment?"
        question[15] = ""
        question[16] = "int x = 3;\nWhat is the output of \nSystem.out.Println(“x + 5”);"
        question[17] = "What is the output of \nSystem.out.Println(10 + 5);"
        question[18] = "What is the output of \nSystem.out.Println(7+3);"
        question[19] = "What is the output of \nSystem.out.Println(“10” + “5”);"
        question[20] = ""
        question[21] = "int x = 7;\nWhat is the output of \nSystem.out.Println(x + “7”);"
        question[22] = "int x = 7;\nWhat is the output of \nSystem.out.Println(“x + 5”);"
        question[23] = "int y = 10;\nint x = 7;\nWhat is the output of \nSystem.out.Println(“x + y”);"
        question[24] = "int y = 10;\nint x = 10;\nWhat is the output of \nSystem.out.Println(x + y);"
        question[25] = ""
        question[26] = "Stores text, such as \"Hello\". String values are surrounded by double quotes"
        question[27] = "Stores integers (whole numbers), without decimals, such as 123 or -123"
        question[28] = "Stores floating point numbers, with decimals, such as 19.99 or -19.99"
        question[29] = "Stores single characters, such as 'a' or 'B'. Char values are surrounded by single quotes"
        question[30] = ""
        question[31] = "What is the operator used in the code below?\nSystem.out.println(10 * 10);?"
        question[32] = "What is the operator used in the code below?\nint x = 5;\nint y = 3;\nint z = x/y;"
        question[33] = "Which of these  in a subtraction operator?"
        question[34] = "Which of these is a modulo operator?"
        question[35] = ""
        question[36] = "x = 3 + 7 / 10 * 30 - 2;\nWhat operation will Java do first?"
        question[37] = "Which of these is a division operator?"
        question[38] = "Which of these is a addition operator?"
        question[39] = "int x = 100 % 10\nWhat is the value of x?"
        question[40] = ""
        question[41] = "int x = 10;\nWhat is the value of x?"
        question[42] = "int x = 10;\nx += 17;\nWhat is the value of x?"
        question[43] = "int x = 10;\nx *= 3;\nWhat is the value of x?"
        question[44] = "int x = 10;\nx /= 2;\nWhat is the value of x?"
        question[45] = ""
        question[46] = "int x = 10;\nx %= 5;\nWhat is the value of x?"
        question[47] = "int x = 10;\nx += 7;\nx -= 5;\nWhat is the value of x?"
        question[48] = "int x = 10;\nx += 7;\nx *= 2;\nWhat is the value of x?"
        question[49] = "int x = 10;\nx += 7;\nx /= 1;\nWhat is the value of x?"
        question[50] = ""
        question[51] = ""
        question[52] = ""
        question[53] = ""
        question[54] = ""
        question[55] = ""
        question[56] = ""
        question[57] = ""
        question[58] = ""
        question[59] = ""
        question[60] = ""
        question[61] = ""
        question[62] = ""
        question[63] = ""
        question[64] = ""
        question[65] = ""
        question[66] = ""
        question[67] = ""
        question[68] = ""
        question[69] = ""
        question[70] = ""



        //answers
        answer[0] = "System.out.println(\"Hello World\");"
        answer[1] = "Semicolon"
        answer[2] = "main()"
        answer[3] = "Parenthesis"
        answer[4] = "out"
        answer[5] = "Fcb3"
        answer[6] = "Line break"
        answer[7] = "Hello\nWorld"
        answer[8] = "Cat"
        answer[9] = "7"
        answer[10] = "System.out.println(\"Hello World\");"
        answer[11] = "//"
        answer[12] = "Comments are used as a note"
        answer[13] = "One"
        answer[14] = "/*   */"
        answer[15] = "Fcb2"
        answer[16] = "x + 5"
        answer[17] = "15"
        answer[18] = "10"
        answer[19] = "105"
        answer[20] = "System.out.println(7 + 7);"
        answer[21] = "77"
        answer[22] = "x + 5"
        answer[23] = "x + y"
        answer[24] = "20"
        answer[25] = "Fcb3"
        answer[26] = "String"
        answer[27] = "int"
        answer[28] = "boolean"
        answer[29] = "char"
        answer[30] = "System.out.println(x + y);"
        answer[31] = "Multiplication"
        answer[32] = "Division"
        answer[33] = "100 - 10;"
        answer[34] = "100 % 10"
        answer[35] = "Fcb3"
        answer[36] = "10"
        answer[37] = "/"
        answer[38] = "%"
        answer[39] = "0"
        answer[40] = "int x + 3 + 7;"
        answer[41] = "10"
        answer[42] = "27"
        answer[43] = "30"
        answer[44] = "5"
        answer[45] = "Fcb1"
        answer[46] = "0"
        answer[47] = "12"
        answer[48] = "34"
        answer[49] = "17"
        answer[50] = "int x = 10;\nx += 100;"
        answer[51] = ""
        answer[52] = ""
        answer[53] = ""
        answer[54] = ""
        answer[55] = ""
        answer[56] = ""
        answer[57] = ""
        answer[58] = ""
        answer[59] = ""
        answer[60] = ""
        answer[61] = ""
        answer[62] = ""
        answer[63] = ""
        answer[64] = ""
        answer[65] = ""
        answer[66] = ""
        answer[67] = ""
        answer[68] = ""
        answer[69] = ""
        answer[70] = ""


        //cb1
        cb1[0] = "println(\"Hello World\")"
        cb1[1] = "Double quotation marks"
        cb1[2] = "void"
        cb1[3] = "Double quotation marks"
        cb1[4] = "Parenthesis"
        cb1[5] = "f1"
        cb1[6] = "Space"
        cb1[7] = "Hello\nWorld"
        cb1[8] = "\"Cat\""
        cb1[9] = "7"
        cb1[10] = "code1"
        cb1[11] = "#"
        cb1[12] = "Comments are used for calculations"
        cb1[13] = "One"
        cb1[14] = "\\\\"
        cb1[15] = "f2"
        cb1[16] = "x + 5"
        cb1[17] = "10 + 5"
        cb1[18] = "10"
        cb1[19] = "15"
        cb1[20] = "code2"
        cb1[21] = "77"
        cb1[22] = "12"
        cb1[23] = "107"
        cb1[24] = "1010"
        cb1[25] = "f3"
        cb1[26] = "char"
        cb1[27] = "boolean"
        cb1[28] = "String"
        cb1[29] = "int"
        cb1[30] = "code3"
        cb1[31] = "Addition"
        cb1[32] = "Multiplication"
        cb1[33] = "100 - 10;"
        cb1[34] = "100 - 10"
        cb1[35] = "f4"
        cb1[36] = "12"
        cb1[37] = "*"
        cb1[38] = "/"
        cb1[39] = "0"
        cb1[40] = "code4"
        cb1[41] = "10"
        cb1[42] = "25"
        cb1[43] = "4"
        cb1[44] = "5"
        cb1[45] = "f5"
        cb1[46] = "10"
        cb1[47] = "3"
        cb1[48] = "34"
        cb1[49] = "20"
        cb1[50] = "code5"
        cb1[51] = ""
        cb1[52] = ""
        cb1[53] = ""
        cb1[54] = ""
        cb1[55] = ""
        cb1[56] = ""
        cb1[57] = ""
        cb1[58] = ""
        cb1[59] = ""
        cb1[60] = ""
        cb1[61] = ""
        cb1[62] = ""
        cb1[63] = ""
        cb1[64] = ""
        cb1[65] = ""
        cb1[66] = ""
        cb1[67] = ""
        cb1[68] = ""
        cb1[69] = ""
        cb1[70] = ""



        //cb2
        cb2[0] = "print(\"hello World\")"
        cb2[1] = "Parenthesis"
        cb2[2] = "var"
        cb2[3] = "Parenthesis"
        cb2[4] = "dot"
        cb2[5] = ""
        cb2[6] = "boolean"
        cb2[7] = "Hello\\nWorld"
        cb2[8] = "7"
        cb2[9] = "Seven"
        cb2[10] = ""
        cb2[11] = "\\\\"
        cb2[12] = "Comments are used as a note"
        cb2[13] = "Two"
        cb2[14] = "//"
        cb2[15] = ""
        cb2[16] = "8"
        cb2[17] = "15"
        cb2[18] = "7 + 3"
        cb2[19] = "10 + 5"
        cb2[20] = ""
        cb2[21] = "x + 7"
        cb2[22] = "x + 5"
        cb2[23] = "17"
        cb2[24] = "20"
        cb2[25] = ""
        cb2[26] = "String"
        cb2[27] = "int"
        cb2[28] = "char"
        cb2[29] = "boolean"
        cb2[30] = ""
        cb2[31] = "Subtraction"
        cb2[32] = "Division"
        cb2[33] = "100 * 10"
        cb2[34] = "100 / 10"
        cb2[35] = ""
        cb2[36] = "10"
        cb2[37] = "/"
        cb2[38] = "*"
        cb2[39] = "10"
        cb2[40] = ""
        cb2[41] = "11"
        cb2[42] = "17"
        cb2[43] = "32"
        cb2[44] = "12"
        cb2[45] = ""
        cb2[46] = "0"
        cb2[47] = "10"
        cb2[48] = "35"
        cb2[49] = "17"
        cb2[50] = ""
        cb2[51] = ""
        cb2[52] = ""
        cb2[53] = ""
        cb2[54] = ""
        cb2[55] = ""
        cb2[56] = ""
        cb2[57] = ""
        cb2[58] = ""
        cb2[59] = ""
        cb2[60] = ""
        cb2[61] = ""
        cb2[62] = ""
        cb2[63] = ""
        cb2[64] = ""
        cb2[65] = ""
        cb2[66] = ""
        cb2[67] = ""
        cb2[68] = ""
        cb2[69] = ""
        cb2[70] = ""

        //cb3
        cb3[0] = "System.out.println(\"Hello World\");"
        cb3[1] = "Semicolon"
        cb3[2] = "main()"
        cb3[3] = "Semicolon"
        cb3[4] = "out"
        cb3[5] = ""
        cb3[6] = "Line break"
        cb3[7] = "Hello World"
        cb3[8] = "Cat"
        cb3[9] = "\"7\""
        cb3[10] = ""
        cb3[11] = "//"
        cb3[12] = "Comments are used for output"
        cb3[13] = "Three"
        cb3[14] = "/*   */"
        cb3[15] = ""
        cb3[16] = "9"
        cb3[17] = "16"
        cb3[18] = "4"
        cb3[19] = "105"
        cb3[20] = ""
        cb3[21] = "14"
        cb3[22] = "75"
        cb3[23] = "x + y"
        cb3[24] = "x + y"
        cb3[25] = ""
        cb3[26] = "int"
        cb3[27] = "String"
        cb3[28] = "boolean"
        cb3[29] = "char"
        cb3[30] = ""
        cb3[31] = "Multiplication"
        cb3[32] = "Subtraction"
        cb3[33] = "100 + 10"
        cb3[34] = "100 % 10"
        cb3[35] = ""
        cb3[36] = "9"
        cb3[37] = "+"
        cb3[38] = "%"
        cb3[39] = "1"
        cb3[40] = ""
        cb3[41] = "1000"
        cb3[42] = "27"
        cb3[43] = "30"
        cb3[44] = "30"
        cb3[45] = "2"
        cb3[46] = "1"
        cb3[47] = "12"
        cb3[48] = "9"
        cb3[49] = "1"
        cb3[50] = ""
        cb3[51] = ""
        cb3[52] = ""
        cb3[53] = ""
        cb3[54] = ""
        cb3[55] = ""
        cb3[56] = ""
        cb3[57] = ""
        cb3[58] = ""
        cb3[59] = ""
        cb3[60] = ""
        cb3[61] = ""
        cb3[62] = ""
        cb3[63] = ""
        cb3[64] = ""
        cb3[65] = ""
        cb3[66] = ""
        cb3[67] = ""
        cb3[68] = ""
        cb3[69] = ""
        cb3[70] = ""






        /*
        var db1 = helper.writableDatabase
        for (x in 0..100){
            db1.delete("Table1", "ITEMNUMBER"+"=?", arrayOf(x.toString()))
        }
         */

        var cv = ContentValues()

        for(x in 0..70){
            cv.put("ITEMNUMBER", item[x].toInt())
            cv.put("QUESTION", question[x])
            cv.put("ITEM1", cb1[x])
            cv.put("ITEM2", cb2[x])
            cv.put("ITEM3", cb3[x])
            cv.put("ANSWER", answer[x])
            db.insert("Table1",null,cv)
        }


    }
}