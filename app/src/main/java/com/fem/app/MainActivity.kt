package com.fem.app

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.google.android.material.button.MaterialButton
import android.view.View
import android.content.Intent
import android.net.Uri

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Enable edge-to-edge display
        WindowCompat.setDecorFitsSystemWindows(window, false)
        
        setContentView(R.layout.activity_main)

        // Set up button click listeners
        findViewById<MaterialButton>(R.id.btnGetStarted).setOnClickListener {
            showToast("Welcome to FEM! Let's get started on your journey.")
        }

        findViewById<MaterialButton>(R.id.btnExplore).setOnClickListener {
            showToast("Explore the amazing features of FEM!")
        }

        // Set up footer link listeners
        findViewById<View>(R.id.tvPrivacyPolicy).setOnClickListener {
            showToast("Privacy Policy - Coming Soon")
            // In production, this would open the privacy policy
            // openUrl("https://yourapp.com/privacy")
        }

        findViewById<View>(R.id.tvTermsOfService).setOnClickListener {
            showToast("Terms of Service - Coming Soon")
            // In production, this would open the terms of service
            // openUrl("https://yourapp.com/terms")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun openUrl(url: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        } catch (e: Exception) {
            showToast("Unable to open link")
        }
    }
}
