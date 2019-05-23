package com.gustavobarbosa.fooddelivery.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gustavobarbosa.fooddelivery.R
import com.gustavobarbosa.fooddelivery.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.container,fragment).commit()
    }
}
