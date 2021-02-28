package io.davidosemwota.puppy.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.davidosemwota.puppy.R
import io.davidosemwota.puppy.ui.theme.PuppyTheme

@Composable
fun Main() {
    Surface(Modifier.fillMaxSize()) {
        MainScreen(

        )
    }
}

@Composable
fun MainAppBar(
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Row {
                Text(
                    text = stringResource(id = R.string.app_name),
                    modifier = Modifier
                        .padding(start = 4.dp, end = 4.dp)
                )

                Image(
                    painter = painterResource(R.drawable.ic_puppy),
                    contentDescription = stringResource(R.string.puppy_app_icon_desc),
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val appBarColor = MaterialTheme.colors.surface.copy(alpha = 0.87f)

    Column(
        modifier = modifier
    ) {
        Spacer(
            Modifier
                .background(appBarColor)
                .fillMaxWidth()
        )
        MainAppBar(
            backgroundColor = appBarColor,
            modifier = Modifier.fillMaxWidth()
        )
    }

}

@Composable
@Preview
fun PreviewMain() {
    PuppyTheme {
        Main()
    }
}
