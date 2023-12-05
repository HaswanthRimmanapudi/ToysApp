package com.haswanth.toysapp

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.haswanth.toysapp.app.Toyapps

class SplashAct : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scale = remember {
                Animatable(0f)
            }
            val overshootInterpolator = remember {
                OvershootInterpolator(2f)
            }
            LaunchedEffect(key1 = true) {
                scale.animateTo(
                    targetValue = 0.5f,
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = {
                            overshootInterpolator.getInterpolation(it)
                        }
                    )
                )


//        delay(Constants.SPLASH_SCREEN_DURATION)
//        navController.popBackStack()
//        navController.navigate(MainActivity.route)

            }

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.toy),
                    contentDescription = "Logo",
//                    modifier = Modifier.scale(scale().value)
                )
            }

              Toyapps()
        }
    }

}