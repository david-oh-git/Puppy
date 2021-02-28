package io.davidosemwota.puppy

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import io.davidosemwota.puppy.ui.main.Main
import io.davidosemwota.puppy.ui.theme.PuppyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuppyTheme {
                Main()
            }
        }
    }
}
