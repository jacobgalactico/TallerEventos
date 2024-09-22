package com.example.tallereventos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PantallaConfiguracion(colorFondo: Color, onColorSelected: (Color) -> Unit, onVolverInicio: () -> Unit) {
    // Aquí usamos el colorFondo global pasado desde MainActivity
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorFondo)  // Aplicar el color de fondo global
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Selecciona un color de fondo", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        // Botones de selección de color
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(onClick = { onColorSelected(Color.Blue) }) {
                Text("Azul")
            }
            Button(onClick = { onColorSelected(Color.Green) }) {
                Text("Verde")
            }
            Button(onClick = { onColorSelected(Color.Red) }) {
                Text("Rojo")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Botón para volver a la pantalla de inicio
        Button(onClick = onVolverInicio) {
            Text("Volver a la pantalla de inicio")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaConfiguracionPreview() {
    PantallaConfiguracion(colorFondo = Color.White, onColorSelected = {}, onVolverInicio = {})
}
