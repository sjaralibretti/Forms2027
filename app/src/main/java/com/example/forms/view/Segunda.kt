package com.example.forms.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.forms.viewmodel.UsuarioViewModel

@Composable
fun segunda(navController: NavController, viewModel: UsuarioViewModel) {

    val estado by viewModel.estado.collectAsState()

    Column(
        Modifier.fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Resumen de Login", style = MaterialTheme.typography.headlineMedium)
        Text("Usuario: ${estado.usuario}")
        Text("Clave: ${estado.clave}")

        Button(onClick = {navController.navigate("HomeScreen")},
            Modifier.fillMaxWidth()) {
            Text("Ir atrás")
        }
    }

}