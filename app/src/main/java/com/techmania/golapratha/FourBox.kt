package com.techmania.golapratha

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import kotlin.random.Random

@Composable
fun FourBox()  {


    var text1 by remember { mutableStateOf("") }
    var clickedButtonState by remember { mutableStateOf(false) }

    var text2 by remember { mutableStateOf("") }
    var text3 by remember { mutableStateOf("") }
    var text4 by remember { mutableStateOf("") }
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
            TextField(value = text4, onValueChange = {
                text4 = it
            } )

            Button( onClick = {


                clickedButtonState = !clickedButtonState




            }) {
                Text(text = "Submit")

            }

            if (clickedButtonState) {

                val randomNum = Random.nextInt(1, 5)

                if (randomNum == 1)  {

                    Box() {
                        Text(text = "$text1")
                    }
                } else if (randomNum == 2) {
                    Box() {
                        Text(text = "$text2")
                    }
                } else if (randomNum == 3) {
                    Box() {
                        Text(text = "$text3")
                    }
                } else {
                    Box() {
                        Text(text = "$text4")
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