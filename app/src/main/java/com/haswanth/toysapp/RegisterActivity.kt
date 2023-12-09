package com.haswanth.toysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.haswanth.toysapp.components.ButtonComponent
import com.haswanth.toysapp.components.CheckboxComponent
import com.haswanth.toysapp.components.ClickableLoginTextComponent
import com.haswanth.toysapp.components.DividerTextComponent
import com.haswanth.toysapp.components.HeadingTextComponent
import com.haswanth.toysapp.components.MyTextFieldComponent
import com.haswanth.toysapp.components.PasswordTextFieldComponent
import com.haswanth.toysapp.data.signup.SignupUIEvent
import com.haswanth.toysapp.navigation.Screen
import com.haswanth.toysapp.navigation.ToysAppRouter
import com.haswanth.toysapp.ui.theme.ToysAppTheme

class RegisterActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToysAppTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        androidx.compose.material.Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {

            Column(modifier = Modifier.fillMaxSize()) {
                Image(painter = painterResource(id = R.drawable.toy),contentDescription = null)
                HeadingTextComponent(value = "Toys Application")
                Spacer(modifier = Modifier.height(8.dp))

                Button(onClick = {
//                    viewModel.saveData(text.value)
                }) {
                    androidx.compose.material.Text(text = "Save Name")
                }


                MyTextFieldComponent(
                    labelValue = stringResource(id = R.string.first_name),
                    painterResource(id = R.drawable.profile),
                    onTextChanged = {
                    },
                )

                MyTextFieldComponent(
                    labelValue = stringResource(id = R.string.last_name),
                    painterResource = painterResource(id = R.drawable.profile),
                    onTextChanged = {
                    },
                )

                MyTextFieldComponent(
                    labelValue = stringResource(id = R.string.email),
                    painterResource = painterResource(id = R.drawable.message),
                    onTextChanged = {
                    },
                )

                PasswordTextFieldComponent(
                    labelValue = stringResource(id = R.string.password),
                    painterResource = painterResource(id = R.drawable.ic_lock),
                    onTextSelected = {
                    },
                )

                CheckboxComponent(value = stringResource(id = R.string.terms_and_conditions),
                    onTextSelected = {
                        ToysAppRouter.navigateTo(Screen.TermsAndConditionsScreen)
                    },
                    onCheckedChange = {
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))

                ButtonComponent(
                    value = stringResource(id = R.string.register),
                    onButtonClicked = {

                    },
                )

                Spacer(modifier = Modifier.height(10.dp))

                DividerTextComponent()

                ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {
                    ToysAppRouter.navigateTo(Screen.LoginScreen)
                })
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToysAppTheme {
        Greeting("Android")
    }
}