package com.aulasandroid.idadeexercicio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.idadeexercicio.ui.theme.IdadeExercicioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IdadeExercicioTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComponentsScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ComponentsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var idade by remember {
            mutableStateOf(0)
        }

        var message: String = when {
            idade > 0 -> "Você é MENOR de idade"
            idade >= 18git a -> "Você é MAIOR de idade"
            else -> ""
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Qual é a sua idade?",
                    color = Color.Blue,
                    fontSize = 28.sp
                )

                Text(
                    text = "Aperte os botões para informar a sua idade"
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)

            ) {
                Text(
                    text = idade.toString(),
                    fontSize = 44.sp
                )
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            if (idade > 0)
                                idade--
                        },
                        modifier = Modifier
                            .size(60.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Blue,
                            contentColor = Color.White
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .size(60.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "-",
                                fontSize = 36.sp
                            )
                        }
                    }
//                    Spacer(
//                        modifier = Modifier
//                            .width(20.dp)
//                    )
                    Button(
                        onClick = {
                            if (idade < 180)
                            idade++
                        },
                        modifier = Modifier
                            .size(60.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Blue,
                            contentColor = Color.White
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            Arrangement.Center,
                            Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "+",
                                fontSize = 36.sp
                            )
                        }
                    }
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = message,
                    color = Color.Blue,
                    fontSize = 28.sp
                )
            }
        }

    }
}

//@Composable
//fun ButtonAge(texto: String) {
//    Button(
//        onClick = {
//            if (texto == "-") {
//                idade --
//            } else if (texto == "+"){
//                idade ++
//            }
//        },
//        modifier = Modifier
//            .size(60.dp),
//        shape = RoundedCornerShape(10.dp),
//        colors = ButtonDefaults.buttonColors(
//            containerColor = Color.Blue,
//            contentColor = Color.White
//        )
//    ) {
//        Row(
//            modifier = Modifier
//                .size(60.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Center
//        ) {
//            Text(
//                text = texto,
//                fontSize = 36.sp
//            )
//        }
//    }
//}