package io.davidosemwota.puppy.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.chrisbanes.accompanist.coil.CoilImage
import io.davidosemwota.puppy.R
import io.davidosemwota.puppy.data.Pup
import io.davidosemwota.puppy.ui.theme.PuppyTheme
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign

@Composable
fun Main() {
    val viewModel = viewModel(MainViewModel::class.java)
    val viewState by viewModel.state.collectAsState()

    Surface(Modifier.fillMaxSize()) {
        MainScreen(
            viewState.puppies
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
    puppies: List<Pup>,
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

        PuppiesList(
            puppies = puppies,
            modifier = Modifier.fillMaxWidth()
        )
    }

}

@Composable
fun PuppiesList(
    puppies: List<Pup>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(all = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        items(puppies) { pup ->
            PuppyItem(pup = pup)
        }
    }
}

@Composable
fun PuppyItem(
    pup: Pup
) {
    Card(
        elevation = 4.dp
    ) {
        Column {
            CoilImage(
                data = pup.imageUrl,
                contentDescription = stringResource(R.string.puppy_item_image_desc),
                loading = {

                },
                error = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_broken_image),
                        contentDescription = stringResource(R.string.broken_image_desc)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(MaterialTheme.shapes.medium)
            )
            Text(
                text = pup.name,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

}

@Composable
@Preview
fun PreviewMain() {
    PuppyTheme {
        Main()
    }
}
