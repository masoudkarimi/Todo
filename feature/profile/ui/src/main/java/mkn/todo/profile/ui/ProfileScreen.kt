package mkn.todo.profile.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val ProfileRoute = "profile"

fun NavGraphBuilder.profileScreen() {
    composable(ProfileRoute) {
        val viewModel : ProfileViewModel = hiltViewModel()
        val uiState by viewModel.uiState.collectAsState()
        ProfileScreen(uiState = uiState)
    }
}

@Composable
internal fun ProfileScreen(
    uiState: String,
) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = uiState)
    }
}