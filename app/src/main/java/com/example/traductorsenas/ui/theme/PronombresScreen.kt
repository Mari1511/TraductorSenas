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

// PANTALLA: PRONOMBRES
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PronombresScreen(navController: NavController) {
    val items = listOf(
        "Él 👦",
        "Ella 👧",
        "Mío 🙋‍♂️",
        "Nosotros 👥",
        "Nuestro 👥",
        "Suyo 👤",
        "Tú 👉",
        "Tuyo 👉",
        "Ustedes 👥",
        "Yo 🧑"
    )

    // Mapeo entre cada pronombre y su ruta correspondiente.
    // Se recomienda usar identificadores sin acentos para las rutas.
    val pronounRoutes = mapOf(
        "Él 👦" to "elScreen",
        "Ella 👧" to "ellaScreen",
        "Mío 🙋‍♂️" to "mioScreen",
        "Nosotros 👥" to "nosotrosScreen",
        "Nuestro 👥" to "nuestroScreen",
        "Suyo 👤" to "suyoScreen",
        "Tú 👉" to "tuScreen",
        "Tuyo 👉" to "tuyoScreen",
        "Ustedes 👥" to "ustedesScreen",
        "Yo 🧑" to "yoScreen"
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Pronombres") },
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
                            pronounRoutes[item]?.let { route ->
                                navController.navigate(route)
                            }
                        },
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
                ) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(16.dp)) {
                        Text(text = item, style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
        }
    }
}
