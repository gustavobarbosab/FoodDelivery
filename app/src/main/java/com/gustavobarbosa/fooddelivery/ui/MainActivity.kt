package com.gustavobarbosa.fooddelivery.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gustavobarbosa.fooddelivery.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainNavigation: MainNavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigation()
    }

    override fun onDestroy() {
        super.onDestroy()
        mainNavigation.destroy()
    }

    private fun setupBottomNavigation() {
        mainNavigation = MainNavigationManager(this.supportFragmentManager,mainBottomNavigationView)
        mainBottomNavigationView.setOnNavigationItemSelectedListener(mainNavigation)
    }
}
