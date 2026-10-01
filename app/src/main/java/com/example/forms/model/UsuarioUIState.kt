package com.example.forms.model

data class UsuarioUIState(
    val usuario: String = "",
    val clave: String = "",
    val errores: UsuarioErrores = UsuarioErrores()
)
