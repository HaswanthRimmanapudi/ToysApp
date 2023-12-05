package com.haswanth.toysapp.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.haswanth.toysapp.data.home.HomeViewModel
import com.haswanth.toysapp.HomeScreen
import com.haswanth.toysapp.LoginScreen
import com.haswanth.toysapp.data.signup.MainViewModel
import com.haswanth.toysapp.data.signup.SignupViewModel
import com.haswanth.toysapp.navigation.Screen
import com.haswanth.toysapp.navigation.ToysAppRouter
import com.haswanth.toysapp.screens.SignUpScreen
import com.haswanth.toysapp.screens.TermsAndConditionsScreen


@Composable
fun Toyapps(homeViewModel: HomeViewModel = viewModel()) {

    homeViewModel.checkForActiveSession()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        if (homeViewModel.isUserLoggedIn.value == true) {
            ToysAppRouter.navigateTo(Screen.HomeScreen)
        }

        Crossfade(targetState = ToysAppRouter.currentScreen) { currentState ->
            when (currentState.value) {
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }

                is Screen.TermsAndConditionsScreen -> {
                    TermsAndConditionsScreen()
                }

                is Screen.LoginScreen -> {
                    LoginScreen()
                }

                is Screen.HomeScreen -> {
                    HomeScreen()
                }
                else -> {

                }
            }
        }

    }
}
