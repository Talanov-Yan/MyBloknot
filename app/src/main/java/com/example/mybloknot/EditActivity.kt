package com.example.mybloknot

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mybloknot.databinding.EditActivityBinding
import com.example.mybloknot.db.MyDbManager

class EditActivity : AppCompatActivity() {
    lateinit var bindingClassEdit : EditActivityBinding
    var myDbManager = MyDbManager(this)
    private val imageReqestCode = 10
    var tempImageUri = "empty"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClassEdit = EditActivityBinding.inflate(layoutInflater)
        setContentView(bindingClassEdit.root)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == imageReqestCode) {
            bindingClassEdit.imMainImage.setImageURI(data?.data)
            tempImageUri = data?.data.toString()
        }
    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDb()
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }

    fun onClickAddImage(view: View) {
        bindingClassEdit.mainImageLayout.visibility = View.VISIBLE
        bindingClassEdit.fbImage.visibility = View.GONE
    }

    fun onClickDeleteImage(view: View) {
        bindingClassEdit.mainImageLayout.visibility = View.GONE
        bindingClassEdit.fbImage.visibility = View.VISIBLE
    }

    fun onClickChooseImage(view: View) {
        val intent = Intent(Intent.ACTION_PICK) // этот интент позволяет открыть галлерею с картинками
        intent.type = "image/*" // чтобы открывалиь только картинки
        startActivityForResult(intent, imageReqestCode) // надо будет получить ссылку на картнку
    }

    fun onClickSave(view: View) {
        val myTitle = bindingClassEdit.edTitle.text.toString()
        val myDesc = bindingClassEdit.edDesc.text.toString()

        if (myTitle != "" && myDesc != "") {
            myDbManager.insertToDb(myTitle, myDesc, tempImageUri)
        }
    }
}