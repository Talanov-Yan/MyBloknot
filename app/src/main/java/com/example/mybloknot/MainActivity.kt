package com.example.mybloknot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mybloknot.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClassMain: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClassMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClassMain.root)
    }

    fun onClickNew(view: View) {
        val i = Intent(this,EditActivity::class.java)
        startActivity(i)
    }
}