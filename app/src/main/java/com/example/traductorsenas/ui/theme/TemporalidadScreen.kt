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

// PANTALLA: TEMPORALIDAD
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TemporalidadScreen(navController: NavController) {
    val items = listOf(
        "Ahora ⏰",
        "Ahorita ⌛",
        "Año 📅",
        "Ayer 🕰️",
        "Día ☀️",
        "Hasta mañana 🌅",
        "Hoy 📆",
        "Mañana 🌄",
        "Mes 🗓️",
        "Semana 📆"
    )

    // Mapeo entre cada elemento y su ruta correspondiente.
    // Se recomienda eliminar acentos en las rutas para evitar problemas.
    val temporalidadRoutes = mapOf(
        "Ahora ⏰" to "ahoraScreen",
        "Ahorita ⌛" to "ahoritaScreen",
        "Año 📅" to "anoScreen",
        "Ayer 🕰️" to "ayerScreen",
        "Día ☀️" to "diaScreen",
        "Hasta mañana 🌅" to "hastaMananaScreen",
        "Hoy 📆" to "hoyScreen",
        "Mañana 🌄" to "mananaScreen",
        "Mes 🗓️" to "mesScreen",
        "Semana 📆" to "semanaScreen"
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Temporalidad") },
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
                            temporalidadRoutes[item]?.let { route ->
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
