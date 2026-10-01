package com.example.forms.viewmodel

import androidx.lifecycle.ViewModel
import com.example.forms.model.UsuarioErrores
import com.example.forms.model.UsuarioUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class UsuarioViewModel: ViewModel() {

    private val _estado = MutableStateFlow(UsuarioUIState())

    val estado: StateFlow<UsuarioUIState> = _estado

    fun onUsuarioChange(valor: String) {
        _estado.update { it.copy(usuario = valor, errores = it.errores.copy(usuario = null)) }
    }

    fun onClaveChange(valor: String) {
        _estado.update { it.copy(clave = valor, errores = it.errores.copy(clave = null)) }
    }

    fun validarFormulario(): Boolean {
        val estadoActual = _estado.value
        val errores = UsuarioErrores(
            usuario = if(!estadoActual.usuario.contains("@")) "CORREO NO VÁLIDO" else null,
            clave = if(estadoActual.clave.length < 8) "CLAVE DEBE TENER 8 CARACTERES MÍNIMO" else null
        )

        val hayErrores = listOfNotNull(
            errores.usuario,
            errores.clave
        ).isNotEmpty()

        _estado.update { it.copy(errores = errores) }

        return !hayErrores
    }

}