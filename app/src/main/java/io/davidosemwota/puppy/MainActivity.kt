package io.davidosemwota.puppy

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import io.davidosemwota.puppy.ui.PuppyApp
import io.davidosemwota.puppy.ui.theme.PuppyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuppyTheme {
                PuppyApp()
            }
        }
    }
}
