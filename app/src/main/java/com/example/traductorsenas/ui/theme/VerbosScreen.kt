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

// PANTALLA: VERBOS
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerbosScreen(navController: NavController) {
    val items = listOf(
        "Abrir 🔓",
        "Aceptar ✅",
        "Amar ❤️",
        "Ayudar 🤝",
        "Buscar 🔍",
        "Cerrar 🔒",
        "Comer 🍽️",
        "Conocer 🤝",
        "Descubrir 🔎",
        "Dormir 😴",
        "Estudiar 📚",
        "Hablar 🗣️",
        "Ir ➡️",
        "Jugar 🎮",
        "Leer 📖",
        "Querer ❤️",
        "Saber 💡",
        "Ver 👀",
        "Vivir 🌱"
    )

    // Mapeo entre cada verbo y su ruta correspondiente
    val verbRoutes = mapOf(
        "Abrir 🔓" to "abrirScreen",
        "Aceptar ✅" to "aceptarScreen",
        "Amar ❤️" to "amarScreen",
        "Ayudar 🤝" to "ayudarScreen",
        "Buscar 🔍" to "buscarScreen",
        "Cerrar 🔒" to "cerrarScreen",
        "Comer 🍽️" to "comerScreen",
        "Conocer 🤝" to "conocerScreen",
        "Descubrir 🔎" to "descubrirScreen",
        "Dormir 😴" to "dormirScreen",
        "Estudiar 📚" to "estudiarScreen",
        "Hablar 🗣️" to "hablarScreen",
        "Ir ➡️" to "irScreen",
        "Jugar 🎮" to "jugarScreen",
        "Leer 📖" to "leerScreen",
        "Querer ❤️" to "quererScreen",
        "Saber 💡" to "saberScreen",
        "Ver 👀" to "verScreen",
        "Vivir 🌱" to "vivirScreen"
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Verbos") },
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
                            verbRoutes[item]?.let { route ->
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
