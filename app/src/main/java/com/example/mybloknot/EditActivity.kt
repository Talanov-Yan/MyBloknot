package com.example.mybloknot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mybloknot.databinding.EditActivityBinding

class EditActivity : AppCompatActivity() {
    lateinit var bindingClassEdit : EditActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClassEdit = EditActivityBinding.inflate(layoutInflater)
        setContentView(bindingClassEdit.root)
    }

    fun onClickAddImage(view: View) {
        bindingClassEdit.mainImageLayout.visibility = View.VISIBLE
        bindingClassEdit.fbImage.visibility = View.GONE

    }

    fun onClickDeleteImage(view: View) {
        bindingClassEdit.mainImageLayout.visibility = View.GONE
        bindingClassEdit.fbImage.visibility = View.VISIBLE
    }
}