package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName:MyName = MyName("Priyanka")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.doneButId.setOnClickListener {
            doneButtonClick()
            binding.doneButId.visibility = View.GONE
        }
        //val textVieLi :TextView = findViewById(R.id.nick_text_id)
        binding.nickTextId.setOnClickListener {
            updateNickName()

        }
        binding.myName = myName
    }

    private fun doneButtonClick() {
        binding.apply {
            myName?.nickname = nick_edit_id.text.toString()
            invalidateAll()
            //binding.nickTextId.text = binding.nickEditId.text
            binding.nickEditId.visibility = View.GONE
            binding.nickTextId.visibility = View.VISIBLE
        }


    }

    private fun updateNickName() {

        binding.nickEditId.visibility = View.VISIBLE
        binding.doneButId.visibility = View.VISIBLE
        binding.nickTextId.visibility = View.GONE
        binding.nickEditId.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nickEditId, 0)
    }
}
