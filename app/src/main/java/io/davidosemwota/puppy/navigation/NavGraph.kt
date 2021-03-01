package io.davidosemwota.puppy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import io.davidosemwota.puppy.data.Pup
import io.davidosemwota.puppy.ui.main.Main
import io.davidosemwota.puppy.ui.puppydetail.PuppyDetail

@Composable
fun NavGraph(startDestination: String = PuppyDestinations.mainRoute) {
    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }

    NavHost(
        navController = navController,
        startDestination = PuppyDestinations.mainRoute
    ){
        composable(PuppyDestinations.mainRoute) { Main(actions.mainToPuppyDetails) }
        composable(
            PuppyDestinations.puppyDetailRoute + "{${PuppyDestinations.pupDetailKey}}",
            arguments = listOf(
                navArgument(PuppyDestinations.pupDetailKey) {
                    type = NavType.IntType
                }
            )
        ) {  backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            PuppyDetail(
                id = arguments.getInt(PuppyDestinations.pupDetailKey),
                navigateBack = actions.upPress
            )
        }
    }
}

class MainActions(navController: NavHostController) {
    val mainToPuppyDetails: (Int) -> Unit = { id ->
        navController.navigate(
            "${PuppyDestinations.puppyDetailRoute}${id}"
        ) {
            launchSingleTop = true
        }
    }

    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}
