package com.example.traductorsenas

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AbecedarioScreen(navController: NavController) {
    val letras = ('A'..'Z').toList()
    var letraSeleccionada by remember { mutableStateOf<Char?>(null) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Abecedario en Señas") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors()
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Mostrar la imagen seleccionada
            letraSeleccionada?.let { letra ->
                val imageResId = getDrawableResourceForLetter(letra)
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = "Letra $letra",
                    modifier = Modifier
                        .size(150.dp)
                        .padding(16.dp)
                )
                Text(text = "Letra: $letra", style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(16.dp))
            }

            // Teclado con las letras
            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(letras.size) { index ->
                    val letra = letras[index]
                    Button(
                        onClick = { letraSeleccionada = letra },
                        modifier = Modifier
                            .padding(4.dp)
                            .size(60.dp)
                    ) {
                        Text(text = letra.toString(), style = MaterialTheme.typography.titleLarge)
                    }
                }
            }
        }
    }
}

// Función para obtener el ID del recurso de la imagen según la letra
fun getDrawableResourceForLetter(letra: Char): Int {
    return when (letra) {
        'A' -> R.drawable.a
        'B' -> R.drawable.b
        'C' -> R.drawable.c
        'D' -> R.drawable.d
        'E' -> R.drawable.e
        'F' -> R.drawable.f
        'G' -> R.drawable.g
        'H' -> R.drawable.h
        'I' -> R.drawable.i
        'J' -> R.drawable.j
        'K' -> R.drawable.k
        'L' -> R.drawable.l
        'M' -> R.drawable.m
        'N' -> R.drawable.n
        'O' -> R.drawable.o
        'P' -> R.drawable.p
        'Q' -> R.drawable.q
        'R' -> R.drawable.r
        'S' -> R.drawable.s
        'T' -> R.drawable.t
        'U' -> R.drawable.u
        'V' -> R.drawable.v
        'W' -> R.drawable.w
        'X' -> R.drawable.x
        'Y' -> R.drawable.y
        'Z' -> R.drawable.z
        else -> R.drawable.a // Default en caso de error
    }
}
