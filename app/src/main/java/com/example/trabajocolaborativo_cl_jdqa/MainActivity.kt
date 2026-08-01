package com.example.trabajocolaborativo_cl_jdqa

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvUserInfo: TextView
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sessionManager = SessionManager(this)

        // Vincular vistas de la interfaz
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvUserInfo = findViewById(R.id.tvUserInfo)

        // RETO 2: Verificar si ya existe una sesión guardada previa
        val tokenGuardado = sessionManager.obtenerAccessToken()
        if (tokenGuardado != null) {
            obtenerUsuario(tokenGuardado)
        }

        // RETO 1: Capturar valores de la UI al presionar el botón
        btnLogin.setOnClickListener {
            val user = etUsername.text.toString().trim()
            val pass = etPassword.text.toString().trim()

            if (user.isNotEmpty() && pass.isNotEmpty()) {
                hacerLogin(user, pass)
            } else {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun hacerLogin(usuario: String, clave: String) {
        lifecycleScope.launch {
            try {
                val resp = RetrofitClient.api.login(LoginRequest(usuario, clave))
                if (resp.isSuccessful && resp.body() != null) {
                    val body = resp.body()!!

                    // Guardar tokens localmente
                    sessionManager.guardarTokens(body.accessToken, body.refreshToken)

                    // Consultar información protegida
                    obtenerUsuario(body.accessToken)
                } else {
                    mostrarInfo("Error de credenciales: ${resp.code()}")
                }
            } catch (e: Exception) {
                mostrarInfo("Error de red: ${e.message}")
            }
        }
    }

    private fun obtenerUsuario(accessToken: String) {
        lifecycleScope.launch {
            try {
                val resp = RetrofitClient.api.getCurrentUser("Bearer $accessToken")
                if (resp.isSuccessful) {
                    val user = resp.body()

                    // RETO 3: Mostrar los datos en la pantalla
                    mostrarInfo(
                        """
                        ¡Sesión Activa!
                        
                        ID: ${user?.id}
                        Usuario: ${user?.username}
                        Nombre: ${user?.firstName} ${user?.lastName}
                        Correo: ${user?.email}
                        """.trimIndent()
                    )
                } else if (resp.code() == 401) {
                    // RETO 4: Token expirado/inválido -> Intentar renovar con el refresh token
                    intentarRefrescarToken()
                } else {
                    mostrarInfo("Error al obtener usuario: ${resp.code()}")
                }
            } catch (e: Exception) {
                mostrarInfo("Error de conexión: ${e.message}")
            }
        }
    }

    // RETO 4: Función para renovar sesión si el token expiró
    private fun intentarRefrescarToken() {
        val refreshToken = sessionManager.obtenerRefreshToken()
        if (refreshToken == null) {
            mostrarInfo("Sesión expirada. Inicia sesión de nuevo.")
            return
        }

        lifecycleScope.launch {
            try {
                val resp = RetrofitClient.api.refreshToken(RefreshRequest(refreshToken))
                if (resp.isSuccessful && resp.body() != null) {
                    val nuevoAccess = resp.body()!!.accessToken
                    val nuevoRefresh = resp.body()!!.refreshToken

                    sessionManager.guardarTokens(nuevoAccess, nuevoRefresh)

                    // Reintentar la llamada protegida con el nuevo token
                    obtenerUsuario(nuevoAccess)
                } else {
                    sessionManager.limpiarSesion()
                    mostrarInfo("Tu sesión expiró por completo. Vuelve a ingresar.")
                }
            } catch (e: Exception) {
                mostrarInfo("Error al refrescar token: ${e.message}")
            }
        }
    }

    private fun mostrarInfo(mensaje: String) {
        tvUserInfo.text = mensaje
    }
}