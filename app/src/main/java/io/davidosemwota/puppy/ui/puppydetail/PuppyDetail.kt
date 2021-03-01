package io.davidosemwota.puppy.ui.puppydetail

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.chrisbanes.accompanist.insets.statusBarsPadding
import io.davidosemwota.puppy.data.Pup
import io.davidosemwota.puppy.util.viewModelProviderFactoryOf
import androidx.compose.runtime.getValue

@Composable
fun PuppyDetail(
    id: Int,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val viewModel = viewModel<PuppyDetailViewModel>(
        key = "puppy$id",
        factory = viewModelProviderFactoryOf { PuppyDetailViewModel(id) }
    )
    val viewState by viewModel.state.collectAsState()

    Surface(Modifier.fillMaxSize()) {

        viewState.puppy?.let {
            PuppyDetailScreen(
                pup = it,
                navigateBack = navigateBack,
                modifier
            )
        }
    }
}

@Composable
fun PuppyDetailScreen(
    pup: Pup,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        AppBar(navigateBack = navigateBack, title = pup.name)
        Text(text = "My name is ${pup.name}", style = MaterialTheme.typography.h4)
        Text(text = "We are sailing", style = MaterialTheme.typography.h4)
    }
}

@Composable
fun AppBar(
    title: String,
    navigateBack: () -> Unit
) {
    TopAppBar(
        modifier = Modifier.statusBarsPadding(),
        backgroundColor = Color.Transparent,
        title = {
            Text(
                text = title,
                modifier = Modifier
                    .padding(start = 4.dp, end = 4.dp)

            )
        },
        navigationIcon = {
            IconButton(onClick = navigateBack) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "navigation icon"
                )
            }
        }
    )
}