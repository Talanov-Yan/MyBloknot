package com.example.mybloknot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mybloknot.databinding.ActivityMainBinding
import com.example.mybloknot.db.MyDbManager

class MainActivity : AppCompatActivity() {
    lateinit var bindingClassMain: ActivityMainBinding
    var myDbManager = MyDbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClassMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClassMain.root)
    }
    override fun onResume() {
        super.onResume()
        myDbManager.openDb()

    }

    fun onClickNew(view: View) {
        val i = Intent(this,EditActivity::class.java)
        startActivity(i)
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }
}