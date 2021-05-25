package com.example.mybloknot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mybloknot.databinding.ActivityMainBinding
import com.example.mybloknot.db.MyAdapter
import com.example.mybloknot.db.MyDbManager

class MainActivity : AppCompatActivity() {
    lateinit var bindingClassMain: ActivityMainBinding

    val myAdapter = MyAdapter(ArrayList())
    var myDbManager = MyDbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClassMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClassMain.root)

        init()
    }
    override fun onResume() {
        super.onResume()
        myDbManager.openDb()
        fillAdapter()

    }

    fun onClickNew(view: View) {
        val i = Intent(this,EditActivity::class.java)
        startActivity(i)
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }

    private fun init() {        // инициализируем recycler view
        bindingClassMain.rcView.layoutManager = LinearLayoutManager(this) // элементу будут распологаться по вертикале
        bindingClassMain.rcView.adapter = myAdapter
    }

    fun fillAdapter() {
        myAdapter.upDataAdapter(myDbManager.readDbData())
    }
}