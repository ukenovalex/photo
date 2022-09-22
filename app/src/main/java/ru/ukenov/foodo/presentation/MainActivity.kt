package ru.ukenov.foodo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import ru.ukenov.foodo.R
import ru.ukenov.foodo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment
        val navController = navHostFragment.navController

        navController.addOnDestinationChangedListener {_, _, arguments ->
            binding.customAppBar.isVisible = arguments?.getBoolean("ShowAppBar", false) == true
        }

        binding.btnPopBackStack.setOnClickListener {
            navController.popBackStack()
        }
    }
}