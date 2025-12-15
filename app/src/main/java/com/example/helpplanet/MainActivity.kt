package com.example.helpplanet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.helpplanet.ui.theme.HelpPlanetTheme
import com.example.helpplanet.navigation.HelpPlanetNavHost


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelpPlanetTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    HelpPlanetNavHost()
                }
            }
        }
    }
}
