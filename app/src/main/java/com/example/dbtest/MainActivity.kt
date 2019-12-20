package com.example.dbtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dbtest.Database.AppDB
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var mgr  = supportFragmentManager

    //static
    companion object { lateinit var appDB:AppDB }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appDB = AppDB.getInstance(this)

        btnAdd.setOnClickListener() {
            mgr.beginTransaction().replace(R.id.mainFrame, AddRecordFragment()).commit()
        }

        btnView.setOnClickListener() {
            mgr.beginTransaction().replace(R.id.mainFrame, ViewRecordFragment()).commit()
        }

        btnConfirm.setOnClickListener(){
            mgr.beginTransaction().replace(R.id.mainFrame, DeleteFragment()).commit()
        }
    }

}
