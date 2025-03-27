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

// PANTALLA: SALUDOS
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SaludosScreen(navController: NavController) {
    // Lista de saludos
    val items = listOf(
        "Adiós 👋",
        "Bienvenido 🤗",
        "Buenas Noches 🌙",
        "Buenas Tardes 🌆",
        "Buenos Días ☀️",
        "Gracias 🙏",
        "Hola 👋",
        "Mucho Gusto 😊"
    )

    // Mapeo entre cada saludo y su ruta correspondiente
    val greetingRoutes = mapOf(
        "Adiós 👋" to "adiosScreen",
        "Bienvenido 🤗" to "bienvenidoScreen",
        "Buenas Noches 🌙" to "buenasNochesScreen",
        "Buenas Tardes 🌆" to "buenasTardesScreen",
        "Buenos Días ☀️" to "buenosDiasScreen",
        "Gracias 🙏" to "graciasScreen",
        "Hola 👋" to "holaScreen",
        "Mucho Gusto 😊" to "muchoGustoScreen"
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Saludos") },
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
                            // Navegar a la pantalla correspondiente si existe la ruta
                            greetingRoutes[item]?.let { route ->
                                navController.navigate(route)
                            }
                        },
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer
                    )
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
