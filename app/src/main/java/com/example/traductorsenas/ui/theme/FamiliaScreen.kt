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

// PANTALLA: FAMILIA
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FamiliaScreen(navController: NavController) {
    val items = listOf(
        "Abuela 👵",
        "Abuelo 👴",
        "Bebé 👶",
        "Esposa 👩",
        "Esposo 👨",
        "Hermana 👧",
        "Hermano 👦",
        "Hija 👧",
        "Hijo 👦",
        "Mamá 👩",
        "Nieta 👧",
        "Nieto 👦",
        "Niña 👧",
        "Niño 👦",
        "Papá 👨",
        "Prima 👩",
        "Primo 👨",
        "Sobrina 👧",
        "Sobrino 👦",
        "Tía 👩",
        "Tío 👨"
    )

    // Mapeo entre cada elemento de familia y su ruta correspondiente
    val familyRoutes = mapOf(
        "Abuela 👵" to "abuelaScreen",
        "Abuelo 👴" to "abueloScreen",
        "Bebé 👶" to "bebeScreen",
        "Esposa 👩" to "esposaScreen",
        "Esposo 👨" to "esposoScreen",
        "Hermana 👧" to "hermanaScreen",
        "Hermano 👦" to "hermanoScreen",
        "Hija 👧" to "hijaScreen",
        "Hijo 👦" to "hijoScreen",
        "Mamá 👩" to "mamaScreen",
        "Nieta 👧" to "nietaScreen",
        "Nieto 👦" to "nietoScreen",
        "Niña 👧" to "ninaScreen",
        "Niño 👦" to "ninoScreen",
        "Papá 👨" to "papaScreen",
        "Prima 👩" to "primaScreen",
        "Primo 👨" to "primoScreen",
        "Sobrina 👧" to "sobrinaScreen",
        "Sobrino 👦" to "sobrinoScreen",
        "Tía 👩" to "tiaScreen",
        "Tío 👨" to "tioScreen"
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Familia") },
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
                            familyRoutes[item]?.let { route ->
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
