package com.example.traductorsenas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HablarScreen(navController: NavController) {
    val context = LocalContext.current

    // Crea y recuerda la instancia de ExoPlayer
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            // Configura el MediaItem usando la URI del recurso
            val mediaItem =
                MediaItem.fromUri("android.resource://${context.packageName}/${R.raw.hablar}")
            setMediaItem(mediaItem)
            prepare() // Prepara el reproductor
            playWhenReady = true // Opcional: reproducir automáticamente
        }
    }

    // Asegúrate de liberar el reproductor cuando ya no se necesite
    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Hablar 🗣️") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors()
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // Muestra el video usando AndroidView que integra la PlayerView de ExoPlayer
            AndroidView(
                factory = {
                    PlayerView(context).apply {
                        player = exoPlayer
                        // Puedes personalizar la vista aquí, por ejemplo:
                        useController = true // Mostrar controles del reproductor
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16 / 9f) // Ajusta la relación de aspecto según necesites
            )
        }
    }
}
