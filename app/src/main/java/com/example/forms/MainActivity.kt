package com.example.forms

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.forms.ui.theme.FormsTheme
import com.example.forms.view.inicio
import com.example.forms.view.segunda
import com.example.forms.viewmodel.UsuarioViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            val usuarioViewModel : UsuarioViewModel = viewModel()

            NavHost(navController = navController, startDestination = "HomeScreen") {
                composable("HomeScreen") {
                    inicio(navController, usuarioViewModel)
                }
                composable("Segunda") {
                    segunda(navController, usuarioViewModel)
                }
            }

        }
    }
}


