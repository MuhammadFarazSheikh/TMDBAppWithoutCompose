package com.androidengineer.tmdbapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.androidengineer.tmdbapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        connectBottomNavigationViewWithNavHostFragment()
        setupListeners()
    }

    private fun setupListeners()
    {
        activityMainBinding.acivMenuIcon.setOnClickListener(this)
    }

    private fun openDrawer()
    {
        activityMainBinding.drawerLayout.openDrawer(GravityCompat.START)
    }

    private fun closeDrawer()
    {
        activityMainBinding.drawerLayout.openDrawer(GravityCompat.END)
    }

    private fun connectBottomNavigationViewWithNavHostFragment()
    {
        activityMainBinding.bottomNavigationView.setupWithNavController((supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment).navController)
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.acivMenuIcon -> openDrawer()
        }
    }
}