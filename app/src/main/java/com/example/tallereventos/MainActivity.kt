package com.example.tallereventos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.*
import com.example.tallereventos.ui.theme.TallerEventosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TallerEventosTheme {
                // Estado para el color de fondo (global)
                var colorFondo by remember { mutableStateOf(Color.White) }

                // Controlador de navegación
                val navController = rememberNavController()

                // Navegación entre pantallas
                NavHost(navController = navController, startDestination = "pantallaInicio") {
                    composable("pantallaInicio") {
                        PantallaInicio(
                            onButtonClick = { navController.navigate("pantallaPrincipal") },
                            colorFondo = colorFondo
                        )
                    }
                    composable("pantallaPrincipal") {
                        PantallaPrincipal(
                            onNavigateToConfig = { navController.navigate("pantallaConfiguracion") },
                            colorFondo = colorFondo
                        )
                    }
                    composable("pantallaConfiguracion") {
                        PantallaConfiguracion(
                            colorFondo = colorFondo,  // Pasamos el color global
                            onColorSelected = { nuevoColor ->
                                colorFondo = nuevoColor  // Actualiza el color de fondo globalmente
                            },
                            onVolverInicio = {
                                navController.popBackStack("pantallaInicio", false)
                            }
                        )
                    }
                }
            }
        }
    }
}


