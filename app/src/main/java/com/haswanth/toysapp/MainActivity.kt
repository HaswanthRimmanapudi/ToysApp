package com.haswanth.toysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.haswanth.toysapp.app.Toyapps

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Toyapps()
        }
    }
}

@Preview
@Composable
fun DefaultPreview(){
    Toyapps()
}