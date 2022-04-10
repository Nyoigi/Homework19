package com.example.homework19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework19.presentation.MainFragment
import com.example.homework19.utils.extensions.navigateToFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigateToFragment(fragment = MainFragment())
    }
}