package com.example.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.weatherapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  private lateinit var navControlller: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    setSupportActionBar(toolbar)

    navControlller = Navigation.findNavController(this, R.id.nav_host_fragment)

    bottom_nav.setupWithNavController(navControlller)

    NavigationUI.setupActionBarWithNavController(this, navControlller)
  }

  override fun onSupportNavigateUp(): Boolean {
    return NavigationUI.navigateUp(null, navControlller)
  }
}
