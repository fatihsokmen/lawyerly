package com.github.fatihsokmen.lawyerly.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.github.fatihsokmen.lawyerly.R
import com.github.fatihsokmen.lawyerly.databinding.ActivityHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModel()

    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }
    private val navController: NavController by lazy {
        findNavController(R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setupNavigation()
        observeData()
    }

    private fun setupNavigation() {
        NavigationUI.setupWithNavController(binding.toolbar, navController)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_calendar,
                R.id.navigation_favs,
                R.id.navigation_balance,
                R.id.navigation_settings
            )
        )
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration)
        binding.bottomNavigation.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.navigation_lawyer_details) {
                binding.bottomNavigation.visibility = View.GONE
            } else {
                binding.bottomNavigation.visibility = View.VISIBLE
            }
        }
    }

    private fun observeData() {
        viewModel.onLawyerSelected.observe(this) {
            navController.navigate(R.id.navigation_lawyer_details)
        }
    }
}