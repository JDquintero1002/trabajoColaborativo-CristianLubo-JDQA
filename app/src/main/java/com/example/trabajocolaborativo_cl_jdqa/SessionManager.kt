package com.example.trabajocolaborativo_cl_jdqa

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("user_session", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_ACCESS_TOKEN = "access_token"
        private const val KEY_REFRESH_TOKEN = "refresh_token"
    }

    // Guardar tokens al iniciar sesión
    fun guardarTokens(accessToken: String, refreshToken: String) {
        prefs.edit()
            .putString(KEY_ACCESS_TOKEN, accessToken)
            .putString(KEY_REFRESH_TOKEN, refreshToken)
            .apply()
    }

    // Obtener Access Token
    fun obtenerAccessToken(): String? = prefs.getString(KEY_ACCESS_TOKEN, null)

    // Obtener Refresh Token
    fun obtenerRefreshToken(): String? = prefs.getString(KEY_REFRESH_TOKEN, null)

    // Cerrar sesión
    fun limpiarSesion() {
        prefs.edit().clear().apply()
    }
}