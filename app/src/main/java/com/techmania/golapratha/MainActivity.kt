package com.techmania.golapratha

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.techmania.golapratha.ui.theme.GolaPrathaTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GolaPrathaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                  Column {
                    Greeting()
                  }


                }
            }
        }
    }
}

@Composable
fun TwoBox(updateMoneyCounter: (String) -> Unit)  {
    

    var text1 by remember { mutableStateOf("") }
    var clickedButtonState by remember { mutableStateOf(false) }

   var text2 by remember { mutableStateOf("") }
    Card() {
        Column() {
            TextField(value = text1, onValueChange = {
             text1 = it
            } )
           TextField(value = text2, onValueChange = {
                text2 = it
            } )

            Button( onClick = {

               updateMoneyCounter(text1)
                clickedButtonState = !clickedButtonState




            }) {
                Text(text = "Submit")

            }

            if (clickedButtonState) {

                val randomNum = Random.nextInt(1, 3)

                if (randomNum == 1)  {

                Box() {
                    Text(text = "$text1")
                }
            } else {
                    Box() {
                        Text(text = "$text2")
                    }
            }
            }
                else {
                Box() {

                }
            }


        }
    }
}


@Composable
fun ThreeBox()  {


    var text1 by remember { mutableStateOf("") }
    var clickedButtonState by remember { mutableStateOf(false) }

    var text2 by remember { mutableStateOf("") }
    var text3 by remember { mutableStateOf("") }
    Card() {
        Column() {
            TextField(value = text1, onValueChange = {
                text1 = it
            } )
            TextField(value = text2, onValueChange = {
                text2 = it
            } )

            TextField(value = text3, onValueChange = {
                text3 = it
            } )

            Button( onClick = {

                
                clickedButtonState = !clickedButtonState




            }) {
                Text(text = "Submit")

            }

            if (clickedButtonState) {

                val randomNum = Random.nextInt(1, 4)

                if (randomNum == 1)  {

                    Box() {
                        Text(text = "$text1")
                    }
                } else if (randomNum == 2) { 
                    Box() {
                        Text(text = "$text2")
                    }
                } else {
                    Box() {
                        Text(text = "$text3")
                    }
                }
            }
            else {
                Box() {

                }
            }


        }
    }
}
@Composable
fun popText(param: String ) {
     Text(text = "$param")

}

@Composable
fun Greeting() {
    val context = LocalContext.current
    var buttonClickedStateBox2 by remember {
        mutableStateOf(false)
    }
    var buttonClickedStateBox3 by remember {
        mutableStateOf(false)
    }
    var buttonClickedStateBox4 by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {

        Card() {

            Column {

                Box() {
                    Text(text = "How many users?")

                }


                Button(onClick = {
                    buttonClickedStateBox2 = !buttonClickedStateBox2
                }) {
                    Text(text = "2")
                }

                Button(onClick = {
                    buttonClickedStateBox3 = !buttonClickedStateBox3
                }) {

                    Text(text = "3")
                }
                Button(onClick = {
                    buttonClickedStateBox4 = !buttonClickedStateBox4
                }) {
                    Text(text = "4")
                }

                if (buttonClickedStateBox2) {
                    TwoBox() {
                        Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()
                    }

                } else if (buttonClickedStateBox3) {
                    ThreeBox()
                } else if (buttonClickedStateBox4) {
                    FourBox()
                }


            }
        }
    }
}



/*@Composable




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GolaPrathaTheme {
        Column() {
            Greeting()
            TwoBox("hey", "you")
        }

    }
}

 */