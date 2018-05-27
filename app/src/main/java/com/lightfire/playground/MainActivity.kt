package com.lightfire.playground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import android.widget.Toast
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Example of a call to a native method
        Toast.makeText(this,stringFromJNI(),Toast.LENGTH_LONG).show()
        setupNavigation()
    }

    private fun setupNavigation() {
        val navController = findNavController(R.id.mainNavigationFragment)
        setupActionBarWithNavController(navController)
        bottomNavigationView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp() =
            findNavController(R.id.mainNavigationFragment).navigateUp()


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    private external fun stringFromJNI(): String

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
