package com.example.mybloknot.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class MyDbManager(context: Context) {
    var myDbHelper:MyDbHelper = MyDbHelper(context)
    lateinit var db: SQLiteDatabase

    fun openDb() {
        db = myDbHelper.writableDatabase
    }
    fun insertToDb(title: String, content: String,uri: String) {
        val values = ContentValues().apply {
            put(MyDbNameClass.COLUMN_NAME_TITLE, title)
            put(MyDbNameClass.COLUMN_NAME_CONTENT, content)
            put(MyDbNameClass.COLUMN_NAME_IMAGE_URI, uri)
        }
        db.insert(MyDbNameClass.TABLE_NAME, null, values)
    }

    fun readDbData() : ArrayList<String> {
        val dataList = ArrayList<String>()
        val cursor = db.query(MyDbNameClass.TABLE_NAME, null, null,
                null, null, null, null)

        while (cursor?.moveToNext()!!) {
            val dataText = cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_TITLE))
            dataList.add(dataText.toString())
        }
        cursor.close()
        return dataList
    }
    fun closeDb() {
        myDbHelper.close()
    }
}