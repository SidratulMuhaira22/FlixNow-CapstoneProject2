 package hera.flixnow.made.submission2.ui.components

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import hera.flixnow.made.submission2.MyApplication
import hera.flixnow.made.submission2.R
import hera.flixnow.made.submission2.databinding.ActivityMainBinding
import hera.flixnow.made.core.ui.base.BaseActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi

 class MainActivity : BaseActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {

     private lateinit var navController: NavController

     @ExperimentalCoroutinesApi
     override fun ActivityMainBinding.onCreate(savedInstanceState: Bundle?) {
         (application as MyApplication).appComponent.inject(this@MainActivity)
         val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
         navController = navHostFragment.navController
         binding.navView.setupWithNavController(navController)
     }

     override fun observeViewModel() {}
}