package com.example.aeon_shopping_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.aeon_shopping_kotlin.fragments.AccountFragment
import com.example.aeon_shopping_kotlin.fragments.CartFragment
import com.example.aeon_shopping_kotlin.fragments.HomeFragment
import com.example.aeon_shopping_kotlin.fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_nav_control.*

class Nav_Control : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_control)

        val barcode=findViewById<ImageButton>(R.id.barcode)
        barcode.setOnClickListener{
            val intent=Intent(this,Scanner::class.java)
            startActivity(intent)
        }

        val homeFragment=HomeFragment()
        val cartFragment=CartFragment()
        val accountFragment=AccountFragment()
        val settingsFragment=SettingsFragment()

        makeCurrentFragment(homeFragment)


        bottom_navigation.setOnNavigationItemSelectedListener{
            when (it.itemId){
                R.id.home->makeCurrentFragment(homeFragment)
                R.id.cart->makeCurrentFragment(cartFragment)
                R.id.account->makeCurrentFragment(accountFragment)
                R.id.settings->makeCurrentFragment(settingsFragment)
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.fl_wrapper,fragment)
            commit()
        }

}