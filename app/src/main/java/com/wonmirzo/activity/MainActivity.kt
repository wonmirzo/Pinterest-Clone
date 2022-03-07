package com.wonmirzo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import android.view.WindowManager
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.imageview.ShapeableImageView
import com.wonmirzo.R
import com.wonmirzo.fragment.HomeFragment
import com.wonmirzo.fragment.MessageFragment
import com.wonmirzo.fragment.ProfileFragment
import com.wonmirzo.fragment.SearchFragment

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        configureBottomNavigationView()
    }

    private fun configureBottomNavigationView() {
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        Handler(Looper.getMainLooper()).postDelayed({
            notificationSetup(R.id.navMessage, 7)
        }, 2000)
        bottomNavigationView.setOnItemSelectedListener { item ->
            selectItem(item)
        }
    }

    private fun selectItem(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        when (item.itemId) {
            R.id.navHome -> {
                fragment = HomeFragment()
            }
            R.id.navSearch -> {
                fragment = SearchFragment()
            }
            R.id.navMessage -> {
                notificationClear(R.id.navMessage)
                fragment = MessageFragment()
            }
            R.id.navProfile -> {
                fragment = ProfileFragment()
            }
        }
        supportFragmentManager.beginTransaction().replace(R.id.flFragment, fragment!!).commit()
        return true
    }


    private fun notificationSetup(id: Int, alerts: Int) {
        val notification: BadgeDrawable = bottomNavigationView.getOrCreateBadge(id)
        notification.isVisible = true
        notification.number = alerts
    }

    private fun notificationClear(id: Int) {
        val notification: BadgeDrawable = bottomNavigationView.getBadge(id)!!
        if (notification != null) {
            notification.isVisible = false
            notification.clearNumber()
        }
    }
}