package com.example.singlebutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.singlebutton.ui.theme.SingleButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SingleButtonTheme {
                SingleButton()
            }
        }
    }
}

@Composable
fun SingleButton() {
    val num = remember {
        mutableIntStateOf(0)
    }
    val colorslist = listOf(Color.Black,Color.Red,Color.Yellow,Color.Green)
    val buttonColor = remember {
        mutableStateOf(Color.Black)}
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        Button(onClick =
        {
            num.value +=1
            if (num.value==1){buttonColor.value=colorslist[num.value]}
            else if(num.value==2){buttonColor.value=colorslist[num.value]}
            else{buttonColor.value=colorslist[num.value]
                num.value=0}
        },

            modifier = Modifier.size(260.dp,60.dp),
            colors = ButtonDefaults.buttonColors(buttonColor.value),
            shape = RoundedCornerShape(30.dp),
            border = BorderStroke(3.dp,Color.Black)

        ) {
            Text(text = "Color Button",
                color = Color.White,
                textAlign = TextAlign.Center)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SingleButtonTheme {
        SingleButton()
    }
}