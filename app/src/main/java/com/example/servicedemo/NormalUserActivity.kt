package com.example.servicedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class NormalUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_user)
    }

    fun saveMoneyClick(view: View) {}
    fun getMoneyClick(view: View) {}
    fun loanMoneyClick(view: View) {}
}