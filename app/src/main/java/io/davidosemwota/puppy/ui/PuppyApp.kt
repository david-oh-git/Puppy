package io.davidosemwota.puppy.ui

import androidx.compose.runtime.Composable
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import io.davidosemwota.puppy.navigation.NavGraph

@Composable
fun PuppyApp() {
    ProvideWindowInsets {
        NavGraph()
    }
}