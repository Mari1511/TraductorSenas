package com.example.traductorsenas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.MaterialTheme

// PANTALLA: NÚMEROS
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumerosScreen(navController: NavController) {
    val items = listOf(
        "Uno 1️⃣",
        "Dos 2️⃣",
        "Tres 3️⃣",
        "Cuatro 4️⃣",
        "Cinco 5️⃣",
        "Seis 6️⃣",
        "Siete 7️⃣",
        "Ocho 8️⃣",
        "Nueve 9️⃣",
        "Diez 🔟"
    )

    // Mapeo entre cada número y su ruta correspondiente
    val numberRoutes = mapOf(
        "Uno 1️⃣" to "unoScreen",
        "Dos 2️⃣" to "dosScreen",
        "Tres 3️⃣" to "tresScreen",
        "Cuatro 4️⃣" to "cuatroScreen",
        "Cinco 5️⃣" to "cincoScreen",
        "Seis 6️⃣" to "seisScreen",
        "Siete 7️⃣" to "sieteScreen",
        "Ocho 8️⃣" to "ochoScreen",
        "Nueve 9️⃣" to "nueveScreen",
        "Diez 🔟" to "diezScreen"
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Números") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors()
            )
        }
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            items(items.size) { index ->
                val item = items[index]
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            numberRoutes[item]?.let { route ->
                                navController.navigate(route)
                            }
                        },
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = item, style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
        }
    }
}
