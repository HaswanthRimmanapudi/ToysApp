package com.haswanth.toysapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haswanth.toysapp.OrderSuccessActivity
import com.haswanth.toysapp.R
import com.haswanth.toysapp.components.ButtonComponent
import com.haswanth.toysapp.components.HeadingTextComponent
import com.haswanth.toysapp.components.MyTextFieldComponent
import com.haswanth.toysapp.ui.theme.Primary


class PaymentActivity : ComponentActivity() {

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val context = LocalContext.current
            val gradient45 = Brush.linearGradient(
                colors = listOf(Color.White, Color.Yellow),
                start = Offset(0f, Float.POSITIVE_INFINITY),
                end = Offset(Float.POSITIVE_INFINITY, 0f))

                Surface(
                    modifier = Modifier
                        .background(gradient45)
                        .fillMaxSize()
                        .padding(28.dp)
                ) {

                    Column(modifier = Modifier.fillMaxSize()
                        .background(gradient45),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(painter = painterResource(id = R.drawable.card_png),contentDescription = null)
                        Spacer(modifier = Modifier.height(50.dp))
                        HeadingTextComponent(value = "Payment Details")
                        Spacer(modifier = Modifier.height(15.dp))
                        MyTextFieldComponent(
                            labelValue = "7098 6789 4732 8756",
                            painterResource(id = R.drawable.card_png1),
                            onTextChanged = {

                            },
                        )

                        MyTextFieldComponent(
                            labelValue = "40-34-56",
                            painterResource = painterResource(id = R.drawable.card_png1),
                            onTextChanged = {

                            },
                        )

                        MyTextFieldComponent(
                            labelValue = " 879",
                            painterResource = painterResource(id = R.drawable.card_png1),
                            onTextChanged = {

                            },
                        )

                        Spacer(modifier = Modifier.height(20.dp))
                        val toy = ""
                        Button(
                            modifier = Modifier
                                .wrapContentWidth()
                                .heightIn(48.dp),
                            onClick = {
                                context.startActivity(Intent(context, OrderSuccessActivity::class.java))
                            },
                            contentPadding = PaddingValues(),
                            colors = ButtonDefaults.buttonColors(Color.Transparent),
                            shape = RoundedCornerShape(50.dp),
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .heightIn(48.dp)
                                    .background(
                                        brush = Brush.horizontalGradient(listOf(Primary, Primary)),
                                        shape = RoundedCornerShape(20.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Proceed",
                                    fontSize = 18.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )

                            }

                        }

                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen() {
//    Paymen()
}
