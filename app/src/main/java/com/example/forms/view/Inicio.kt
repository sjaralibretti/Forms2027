package com.example.forms.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.forms.viewmodel.UsuarioViewModel

@Composable
fun inicio(navController: NavController, viewModel: UsuarioViewModel) {

    val estado by viewModel.estado.collectAsState()

    Column(

        Modifier.fillMaxSize()
            .padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login",
            fontSize = 50.sp)
        Spacer(Modifier.height(40.dp))


        OutlinedTextField(
            value = estado.usuario,
            onValueChange = viewModel::onUsuarioChange,
            label = { Text("Usuario") },
            isError = estado.errores.usuario != null,
            supportingText = { estado.errores.usuario?.let {
                    Text(it, color = MaterialTheme.colorScheme.error)
                }
            }
        )

        OutlinedTextField(
            value = estado.clave,
            onValueChange = viewModel::onClaveChange,
            label = { Text("Clave") },
            visualTransformation = PasswordVisualTransformation(),
            isError = estado.errores.clave != null,
            supportingText = { estado.errores.clave?.let {
                Text(it, color = MaterialTheme.colorScheme.error)
            }
            }
        )

        Button(onClick = {
            if (viewModel.validarFormulario()) {
                navController.navigate("Segunda")
            }
        },
            Modifier.fillMaxWidth()) {
            Text("Cliquéame")
        }

    }

}