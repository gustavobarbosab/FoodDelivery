package com.gustavobarbosa.fooddelivery.ui

import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.MenuItem
import com.gustavobarbosa.fooddelivery.R
import com.gustavobarbosa.fooddelivery.ui.cart.CartFragment
import com.gustavobarbosa.fooddelivery.ui.home.HomeFragment
import com.gustavobarbosa.fooddelivery.ui.profile.ProfileFragment

class MainNavigationManager(
    private val fragmentManager: FragmentManager?,
    private val bottomNavigationView: BottomNavigationView?
) :
    BottomNavigationView.OnNavigationItemSelectedListener {

    private var homeFragment: HomeFragment? = HomeFragment.newInstance().apply { retainInstance = true }
    private var cartFragment: CartFragment? = CartFragment.newInstance().apply { retainInstance = true }
    private var profileFragment: ProfileFragment? = ProfileFragment.newInstance().apply { retainInstance = true }

    private var backStackListener = FragmentManager.OnBackStackChangedListener {
        when (getActualFragment()) {
            is HomeFragment -> {
                selectCheckedBottomItem(INDEX_HOME)
            }
            is CartFragment -> {
                selectCheckedBottomItem(INDEX_CART)
            }
            is ProfileFragment -> {
                selectCheckedBottomItem(INDEX_PROFILE)
            }
        }
    }

    init {
        create()
    }

    private fun create() {
        loadFragment(homeFragment, false, TAG_HOME)
        fragmentManager?.addOnBackStackChangedListener(backStackListener)
    }

    private fun getActualFragment(): Fragment? {
        var fragment: Fragment? = null
        fragmentManager?.fragments?.onEach { if(it.isVisible) fragment = it }
        return fragment
    }

    fun destroy() {
        homeFragment = null
        cartFragment = null
        profileFragment = null
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                loadFragment(homeFragment, true, TAG_HOME)
                return true
            }
            R.id.nav_list -> {
                loadFragment(cartFragment, true, TAG_CART)
                return true
            }
            R.id.nav_profile -> {
                loadFragment(profileFragment, true, TAG_PROFILE)
                return true
            }
        }
        return false
    }

    private fun selectCheckedBottomItem(position: Int) {
        bottomNavigationView?.menu?.getItem(position)?.isChecked = true
    }

    private fun loadFragment(fragment: Fragment?,
                             backEnabled: Boolean = false,
                             tag: String) {
        fragment?.let {
            if (it.isVisible) return
            fragmentManager?.beginTransaction()?.let { transaction ->
                transaction.replace(R.id.containerMain, it, tag)
                if (backEnabled) {
                    transaction.addToBackStack(tag)
                }
                transaction.commit()
            }
        }
    }

    companion object {
        private const val INDEX_HOME = 0
        private const val INDEX_CART = 1
        private const val INDEX_PROFILE = 2

        private const val TAG_HOME = "TAG_HOME"
        private const val TAG_CART = "TAG_CART"
        private const val TAG_PROFILE = "TAG_PROFILE"
    }
}
