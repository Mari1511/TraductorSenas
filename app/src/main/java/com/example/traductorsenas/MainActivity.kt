package com.example.traductorsenas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.traductorsenas.ui.theme.BuenosDiasScreen
import com.example.traductorsenas.ui.theme.TraductorSenasTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TraductorSenasTheme {
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = { Text("Traductor de Señas") },
                            colors = TopAppBarDefaults.centerAlignedTopAppBarColors()
                        )
                    }
                ) { padding ->
                    NavHost(
                        navController = navController,
                        startDestination = "mainScreen",
                        modifier = Modifier.padding(padding)
                    ) {
                        composable("mainScreen") { MainScreen(navController) }
                        composable("abecedarioScreen") { AbecedarioScreen(navController) }
                        composable("categoriasScreen") { CategoriasScreen(navController) }
                        composable("educacionScreen") { EducacionScreen(navController) }
                        composable("familiaScreen") { FamiliaScreen(navController) }
                        composable("profesionesScreen") { ProfesionesScreen(navController) }
                        composable("pronombresScreen") { PronombresScreen(navController) }
                        composable("proteccionCivilScreen") { ProteccionCivilScreen(navController) }
                        composable("numerosScreen") { NumerosScreen(navController) }
                        composable("saludScreen") { SaludScreen(navController) }
                        composable("expresionesScreen") { ExpresionesScreen(navController) }
                        composable("saludosScreen") { SaludosScreen(navController) }
                        composable("temporalidadScreen") { TemporalidadScreen(navController) }
                        composable("verbosScreen") { VerbosScreen(navController) }

                        // EducacionScreen.kt
                        composable("bibliotecaScreen") { BibliotecaScreen(navController) }
                        composable("claseScreen") { ClaseScreen(navController) }
                        composable("cuadernoScreen") { CuadernoScreen(navController) }
                        composable("diplomaScreen") { DiplomaScreen(navController) }
                        composable("escuelaScreen") { EscuelaScreen(navController) }
                        composable("estudianteScreen") { EstudianteScreen(navController) }
                        composable("examenScreen") { ExamenScreen(navController) }
                        composable("graduacionScreen") { GraduacionScreen(navController) }
                        composable("inglesScreen") { InglesScreen(navController) }
                        composable("libroScreen") { LibroScreen(navController) }
                        composable("licenciaturaScreen") { LicenciaturaScreen(navController) }
                        composable("pizarronScreen") { PizarronScreen(navController) }
                        composable("preparatoriaScreen") { PreparatoriaScreen(navController) }
                        composable("primariaScreen") { PrimariaScreen(navController) }
                        composable("secundariaScreen") { SecundariaScreen(navController) }
                        composable("universidadScreen") { UniversidadScreen(navController) }

                        // FamiliaScreen.kt
                        composable("abuelaScreen") { AbuelaScreen(navController) }
                        composable("abueloScreen") { AbueloScreen(navController) }
                        composable("bebeScreen") { BebeScreen(navController) }
                        composable("esposaScreen") { EsposaScreen(navController) }
                        composable("esposoScreen") { EsposoScreen(navController) }
                        composable("hermanaScreen") { HermanaScreen(navController) }
                        composable("hermanoScreen") { HermanoScreen(navController) }
                        composable("hijaScreen") { HijaScreen(navController) }
                        composable("hijoScreen") { HijoScreen(navController) }
                        composable("mamaScreen") { MamaScreen(navController) }
                        composable("nietaScreen") { NietaScreen(navController) }
                        composable("nietoScreen") { NietoScreen(navController) }
                        composable("ninaScreen") { NinaScreen(navController) }
                        composable("ninoScreen") { NinoScreen(navController) }
                        composable("papaScreen") { PapaScreen(navController) }
                        composable("primaScreen") { PrimaScreen(navController) }
                        composable("primoScreen") { PrimoScreen(navController) }
                        composable("sobrinaScreen") { SobrinaScreen(navController) }
                        composable("sobrinoScreen") { SobrinoScreen(navController) }
                        composable("tiaScreen") { TiaScreen(navController) }
                        composable("tioScreen") { TioScreen(navController) }

                        // ProfesionesScreen.kt
                        composable("chefScreen") { ChefScreen(navController) }
                        composable("medicoScreen") { MedicoScreen(navController) }
                        composable("policiaScreen") { PoliciaScreen(navController) }
                        composable("profesorScreen") { ProfesorScreen(navController) }

                        // PronombresScreen.kt
                        composable("elScreen") { ElScreen(navController) }
                        composable("ellaScreen") { EllaScreen(navController) }
                        composable("mioScreen") { MioScreen(navController) }
                        composable("nosotrosScreen") { NosotrosScreen(navController) }
                        composable("nuestroScreen") { NuestroScreen(navController) }
                        composable("suyoScreen") { SuyoScreen(navController) }
                        composable("tuScreen") { TuScreen(navController) }
                        composable("tuyoScreen") { TuyoScreen(navController) }
                        composable("ustedesScreen") { UstedesScreen(navController) }
                        composable("yoScreen") { YoScreen(navController) }

                        // ProteccionCivilScreen.kt
                        composable("emergenciaScreen") { EmergenciaScreen(navController) }
                        composable("evacuacionScreen") { EvacuacionScreen(navController) }
                        composable("peligroScreen") { PeligroScreen(navController) }
                        composable("prevencionScreen") { PrevencionScreen(navController) }
                        composable("riesgoScreen") { RiesgoScreen(navController) }
                        composable("seguroScreen") { SeguroScreen(navController) }

                        // NumerosScreen.kt
                        composable("unoScreen") { UnoScreen(navController) }
                        composable("dosScreen") { DosScreen(navController) }
                        composable("tresScreen") { TresScreen(navController) }
                        composable("cuatroScreen") { CuatroScreen(navController) }
                        composable("cincoScreen") { CincoScreen(navController) }
                        composable("seisScreen") { SeisScreen(navController) }
                        composable("sieteScreen") { SieteScreen(navController) }
                        composable("ochoScreen") { OchoScreen(navController) }
                        composable("nueveScreen") { NueveScreen(navController) }
                        composable("diezScreen") { DiezScreen(navController) }

                        // SaludScreen.kt
                        composable("ascoScreen") { AscoScreen(navController) }
                        composable("cansancioScreen") { CansancioScreen(navController) }
                        composable("dolorScreen") { DolorScreen(navController) }
                        composable("enfermedadScreen") { EnfermedadScreen(navController) }
                        composable("medicamentoScreen") { MedicamentoScreen(navController) }
                        composable("nadaScreen") { NadaScreen(navController) }
                        composable("pocoScreen") { PocoScreen(navController) }

                        // ExpresionesScreen.kt
                        composable("comoestasScreen") { ComoEstasScreen(navController) }
                        composable("comotellamasScreen") { ComoTeLlamasScreen(navController) }
                        composable("disculpaScreen") { DisculpaScreen(navController) }
                        composable("porfavorScreen") { PorFavorScreen(navController) }

                        // SaludosScreen.kt
                        composable("adiosScreen") { AdiosScreen(navController) }
                        composable("bienvenidoScreen") { BienvenidoScreen(navController) }
                        composable("buenasnochesScreen") { BuenasNochesScreen(navController) }
                        composable("buenastardesScreen") { BuenasTardesScreen(navController) }
                        composable("buenosdiasScreen") { BuenosDiasScreen(navController) }
                        composable("graciasScreen") { GraciasScreen(navController) }
                        composable("holaScreen") { HolaScreen(navController) }
                        composable("muchogustoScreen") { MuchoGustoScreen(navController) }

                        // TemporalidadScreen.kt
                        composable("ahoraScreen") { AhoraScreen(navController) }
                        composable("ahoritaScreen") { AhoritaScreen(navController) }
                        composable("anoScreen") { AnoScreen(navController) }
                        composable("ayerScreen") { AyerScreen(navController) }
                        composable("diaScreen") { DiaScreen(navController) }
                        composable("hastamananaScreen") { HastaMananaScreen(navController) }
                        composable("hoyScreen") { HoyScreen(navController) }
                        composable("mananaScreen") { MananaScreen(navController) }
                        composable("mesScreen") { MesScreen(navController) }
                        composable("semanaScreen") { SemanaScreen(navController) }

                        // VerbosScreen.kt
                        composable("abrirScreen") { AbrirScreen(navController) }
                        composable("aceptarScreen") { AceptarScreen(navController) }
                        composable("amarScreen") { AmarScreen(navController) }
                        composable("ayudarScreen") { AyudarScreen(navController) }
                        composable("buscarScreen") { BuscarScreen(navController) }
                        composable("cerrarScreen") { CerrarScreen(navController) }
                        composable("comerScreen") { ComerScreen(navController) }
                        composable("conocerScreen") { ConocerScreen(navController) }
                        composable("descubrirScreen") { DescubrirScreen(navController) }
                        composable("dormirScreen") { DormirScreen(navController) }
                        composable("estudiarScreen") { EstudiarScreen(navController) }
                        composable("hablarScreen") { HablarScreen(navController) }
                        composable("irScreen") { IrScreen(navController) }
                        composable("jugarScreen") { JugarScreen(navController) }
                        composable("leerScreen") { LeerScreen(navController) }
                        composable("quererScreen") { QuererScreen(navController) }
                        composable("saberScreen") { SaberScreen(navController) }
                        composable("verScreen") { VerScreen(navController) }
                        composable("vivirScreen") { VivirScreen(navController) }
                    }
                }
            }
        }
    }
}