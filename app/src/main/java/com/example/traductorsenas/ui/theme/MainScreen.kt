package com.example.traductorsenas

import android.content.Intent
import android.speech.RecognizerIntent
import android.app.Activity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {
    // Aquí se guarda lo que el usuario escribe o dicta por voz
    var textInput by remember { mutableStateOf("") }

    // Lanzador de reconocimiento de voz
    val speechRecognizerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val matches = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            if (!matches.isNullOrEmpty()) {
                textInput = matches[0]
            }
        }
    }

    // Filtra la lista global según 'textInput'
    val filteredWords = allWordsRoutes.filter {
        it.first.contains(textInput, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Ingresa texto o usa voz para traducir a lenguaje de señas.")
        Spacer(modifier = Modifier.height(16.dp))

        // Campo de texto para búsqueda manual
        TextField(
            value = textInput,
            onValueChange = { textInput = it },
            label = { Text("Escribe aquí") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para reconocimiento de voz
        Button(
            onClick = {
                val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                    putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                    putExtra(RecognizerIntent.EXTRA_LANGUAGE, "es-MX") // Español México
                    putExtra(RecognizerIntent.EXTRA_PROMPT, "Habla ahora...")
                }
                speechRecognizerLauncher.launch(intent)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("🎤 Usar Voz")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Aquí siguen los botones de Abecedario y Categorías
        Button(
            onClick = { navController.navigate("abecedarioScreen") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("📖 Ver Abecedario")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("categoriasScreen") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("🔖 Categorías")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de resultados filtrados
        Text(text = "Resultados de búsqueda:")
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(filteredWords) { (word, route) ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .clickable {
                            // Navegar a la pantalla correspondiente
                            navController.navigate(route)
                        },
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Text(
                        text = word,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}