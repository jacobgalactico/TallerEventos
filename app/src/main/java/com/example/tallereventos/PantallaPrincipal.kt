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
fun PantallaPrincipal(onNavigateToConfig: () -> Unit, colorFondo: Color) {
    var nombre by remember { mutableStateOf("") }
    var nombreGuardado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorFondo)  // Fondo con el color seleccionado
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Ingresa tu nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { nombreGuardado = nombre }) {
            Text("Guardar nombre")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = if (nombreGuardado.isNotEmpty()) "Nombre guardado: $nombreGuardado" else "No se ha guardado un nombre")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onNavigateToConfig) {
            Text("Ir a Pantalla de Configuración")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaPrincipalPreview() {
    PantallaPrincipal(onNavigateToConfig = {}, colorFondo = Color.White)
}
