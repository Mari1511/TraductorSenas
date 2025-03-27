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

// PANTALLA: EDUCACIÓN
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EducacionScreen(navController: NavController) {
    val items = listOf(
        "Biblioteca 📚",
        "Clase 🏫",
        "Cuaderno 📓",
        "Diploma 🎓",
        "Escuela 🏫",
        "Estudiante 👨‍🎓",
        "Examen 📝",
        "Graduación 🎓",
        "Inglés 🇬🇧",
        "Libro 📖",
        "Licenciatura 🎓",
        "Pizarrón 🖊️",
        "Preparatoria 🏫",
        "Primaria 🏫",
        "Secundaria 🏫",
        "Universidad 🎓"
    )

    // Mapeo entre cada ítem y su ruta correspondiente (se asume que la ruta es el nombre en minúscula sin acentos y sin emoji + "Screen")
    val educationRoutes = mapOf(
        "Biblioteca 📚" to "bibliotecaScreen",
        "Clase 🏫" to "claseScreen",
        "Cuaderno 📓" to "cuadernoScreen",
        "Diploma 🎓" to "diplomaScreen",
        "Escuela 🏫" to "escuelaScreen",
        "Estudiante 👨‍🎓" to "estudianteScreen",
        "Examen 📝" to "examenScreen",
        "Graduación 🎓" to "graduacionScreen",
        "Inglés 🇬🇧" to "inglesScreen",
        "Libro 📖" to "libroScreen",
        "Licenciatura 🎓" to "licenciaturaScreen",
        "Pizarrón 🖊️" to "pizarronScreen", // sin acento
        "Preparatoria 🏫" to "preparatoriaScreen",
        "Primaria 🏫" to "primariaScreen",
        "Secundaria 🏫" to "secundariaScreen",
        "Universidad 🎓" to "universidadScreen"
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Educación") },
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
                            educationRoutes[item]?.let { route ->
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
