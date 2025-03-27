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

// PANTALLA: EXPRESIONES
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpresionesScreen(navController: NavController) {
    val items = listOf(
        "¿Cómo estás? ❓😊",
        "¿Cómo te llamas? ❓🙋",
        "Disculpa 🙏",
        "Por favor 🙏"
    )

    // Mapeo entre cada expresión y su ruta correspondiente
    val expressionRoutes = mapOf(
        "¿Cómo estás? ❓😊" to "comoEstasScreen",
        "¿Cómo te llamas? ❓🙋" to "comoTeLlamasScreen",
        "Disculpa 🙏" to "disculpaScreen",
        "Por favor 🙏" to "porFavorScreen"
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Expresiones") },
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
                            expressionRoutes[item]?.let { route ->
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
