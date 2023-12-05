package com.haswanth.toysapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.haswanth.toysapp.components.HeadingTextComponent

class NewPayActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TomNavigationModalMain()
                }
            }
        }
}


@Composable
fun TomNavigationModalMain(modifier: Modifier = Modifier) {
    EditTextDemo()
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview()
@Composable
 private  fun EditTextDemo() {

    var textValue1 by remember { mutableStateOf("") }
    var textValue2 by remember { mutableStateOf("") }
    var textValue3 by remember { mutableStateOf("") }


    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        HeadingTextComponent(value = "Payment Details")

        Spacer(modifier = Modifier.height(30.dp))

        TextField(
            value = textValue1,
            onValueChange = { newText1 ->
                textValue1 = newText1
            },
            label = { Text("Enter ATM  Number") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))


        TextField(
            value = textValue2,
            onValueChange = { newText2 ->
                textValue2 = newText2
            },
            label = { Text("Enter Sort Code") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.NumberPassword
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = textValue3,
            onValueChange = { newText3 ->
                textValue3 = newText3
            },
            label = { Text("Enter Bank Name ") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "ATM Card Number: $textValue1",

            style = MaterialTheme.typography.titleSmall
        )

        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Sort Code: $textValue2",
            style = MaterialTheme.typography.titleSmall
        )

        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Bank Name : $textValue3",
            style = MaterialTheme.typography.titleSmall
        )

        Spacer(modifier = Modifier.height(5.dp))
        var context = LocalContext.current

        Button(
            onClick = {

                if (textValue1.length == null || textValue1 == ""){
                    Toast.makeText(context, "Enter ATM Card Number", Toast.LENGTH_LONG).show()
                }else if (textValue2.length == null || textValue2  == ""){
                    Toast.makeText(context, "Enter SORT Code", Toast.LENGTH_LONG).show()
                }else if (textValue3 == null || textValue3 == ""){
                    Toast.makeText(context, "Enter Bank Name", Toast.LENGTH_LONG).show()
                }else{
                    context.startActivity(Intent(context, OrderSuccessActivity::class.java))
                }
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            Text("Proceed")
        }

    }




}
