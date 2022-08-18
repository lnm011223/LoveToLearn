package com.lnm011223.lovetolearn

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**

 * @Author liangnuoming
 * @Date 2022/8/13-4:03 下午

 */
class MyDatabaseHelper(val context: Context,name: String,version: Int):SQLiteOpenHelper(context,name,null,version) {
    private val creatErrorBook = "create table ErrorBook (" +
            "id integer primary key autoincrement," +
            "title text," +
            "answer text," +
            "isRight integer," +
            "imgUrl text," +
            "score integer," +
            "videoUrl text)"


    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(creatErrorBook)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}