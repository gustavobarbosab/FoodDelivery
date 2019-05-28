package com.gustavobarbosa.fooddelivery.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.gustavobarbosa.fooddelivery.R
import com.gustavobarbosa.fooddelivery.ui.cart.CartFragment
import com.gustavobarbosa.fooddelivery.ui.home.HomeFragment
import com.gustavobarbosa.fooddelivery.ui.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.mainBottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private val fragmentHome = HomeFragment.newInstance().apply { retainInstance = true }
    private val fragmentCart = CartFragment.newInstance().apply { retainInstance = true }
    private val fragmentProfile = ProfileFragment.newInstance().apply { retainInstance = true }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.container, fragmentHome).commit()
        mainBottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        val selectedItemId = mainBottomNavigationView.selectedItemId
        if (R.id.nav_home != selectedItemId) {
            mainBottomNavigationView.selectedItemId = R.id.nav_home
            changeFragment(fragmentHome, false)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                changeFragment(fragmentHome, false)
            }
            R.id.nav_list -> {
                changeFragment(fragmentCart, false)
            }
            R.id.nav_profile -> {
                changeFragment(fragmentProfile, false)
            }
        }
        return true
    }

    private fun changeFragment(fragment: Fragment,
                               addBackStack: Boolean) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)

        if (addBackStack) {
            fragmentTransaction.addToBackStack(null)
        }

        fragmentTransaction.commit()
    }
}
