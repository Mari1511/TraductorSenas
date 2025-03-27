package com.example.traductorsenas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriasScreen(navController: NavController) {
    // Lista de tuplas (nombre de la categoría, ruta de navegación)
    val categorias = listOf(
        "Educación \uD83C\uDFEB" to "educacionScreen",
        "Familia \uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC66" to "familiaScreen",
        "Profesiones \uD83D\uDC77" to "profesionesScreen",
        "Pronombres \uD83D\uDDE3️" to "pronombresScreen",
        "Protección Civil \uD83D\uDE92" to "proteccionCivilScreen",
        "Números \u0031\u20E3" to "numerosScreen",
        "Salud \uD83D\uDC89" to "saludScreen",
        "Expresiones \uD83D\uDE0D" to "expresionesScreen",
        "Saludos \uD83D\uDC4B" to "saludosScreen",
        "Temporalidad \uD83C\uDF27️" to "temporalidadScreen",
        "Verbos \uD83D\uDCA1" to "verbosScreen"
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Categorías de Señas") },
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
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(categorias.size) { index ->
                    val (categoria, route) = categorias[index]
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                            .clickable { navController.navigate(route) },
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(text = categoria, style = MaterialTheme.typography.titleMedium)
                        }
                    }
                }
            }
        }
    }
}
