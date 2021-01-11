package com.example.servicedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class BankActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank)
    }

    fun normalUserClick(view: View) {
        startActivity(Intent(this, NormalUserActivity::class.java))
    }

    fun bankWorkerClick(view: View) {
        startActivity(Intent(this, BankWorkerActivity::class.java))
    }

    fun bankBossClick(view: View) {
        startActivity(Intent(this, BankBossActivity::class.java))
    }

}