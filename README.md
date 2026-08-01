# 📱 LoginApp — Consumir una API con Token en Android (Kotlin)

> **Reto colaborativo · Fase 2** — Programar en pareja

---

## 👥 Equipo

| Rol | Nombre | Salón |
|-----|--------|-------|
| 🏗️ Creador del repositorio | **Juan David** | ADSO 1 |
| 🖥️ Colaborador (clonó el repo) | **Cristian Lubo** | ADSO 3 |
🖥️ Colaborador (clonó el repo) | **Camilo Andres Luna** | ADSO 3 |

---

## 🗂️ ¿Cómo se organizaron?

**Opción elegida:** [ B ]

**¿Por qué eligieron esa opción?**

> *"Elegimos la Opción B . División por paso + revisión cruzada porque fue la mwjor opcion debido a tiempo y para prevenir posibles errores que se pueden dar cuando se trabajn en un mismo archivo (opcion A)"*

---

## 🛠️ Avance por la guía base

Recorrimos los 8 pasos de la guía base juntos, siguiendo el esquema de organización que elegimos:

| Paso | Descripción | Quién escribió el código | Commit representativo |
|------|-------------|--------------------------|----------------------|
| 1 | Conocer la API (endpoints, login, token) | Ambos (lo revisamos juntos en pantalla compartida) | — |
| 2 | Crear el proyecto y permiso de Internet | [Nombre del integrante] | `Crea proyecto Android con Empty Views Activity y permiso de Internet` |
| 3 | Agregar dependencias (Retrofit, Gson, OkHttp, corrutinas) | [Nombre del integrante] | `Agrego dependencias de Retrofit, Gson, OkHttp Logging y corrutinas` |
| 4 | Modelar los datos (data classes) | [Nombre del integrante] | `Creo data classes para LoginRequest, LoginResponse y User` |
| 5 | Declarar los endpoints (interfaz) | [Nombre del integrante] | `Declaro endpoints de login y perfil de usuario en ApiService` |
| 6 | Construir el cliente Retrofit | [Nombre del integrante] | `Construyo cliente Retrofit con interceptor de logging` |
| 7 | Unir todo: login → guardar token → pedir datos | [Nombre del integrante] | `Implemento login con validación, guardado de token y muestra de datos` |
| 8 | Probar y leer el resultado en el Logcat | Ambos | `Verifico login exitoso y datos de usuario en Logcat` |

---

## ➕ Avance por la extensión

| Mejora | Descripción | Commit representativo |
|--------|-------------|----------------------|
| **EditText + botón** | Reemplazamos las credenciales fijas por dos `EditText` (usuario y contraseña) y un botón "Ingresar". | `Reemplazo credenciales fijas por campos de entrada de usuario` |
| **Mostrar en pantalla** | Agregamos un `TextView` para mostrar nombre, correo y un mensaje visible si el login falla (en lugar de solo dejarlo en Logcat). | `Muestra nombre y correo del usuario en TextView en lugar de Logcat` |
| **SharedPreferences** | Guardamos el token en `SharedPreferences` para que, al volver a abrir la app, si ya hay sesión guardada se salte el formulario y pida directo los datos del usuario. | `Implemento guardado del token en SharedPreferences tras login exitoso` |

---

## ⚠️ Dificultades al sincronizar e integrar el trabajo

### Dificultad 1: [Ejemplo: Conflicto de merge al hacer push]

**¿Qué pasó?**
> Escribe aquí qué ocurrió. Por ejemplo:
> *"A ambos se nos olvidó hacer `git pull` antes de empezar a escribir. Cuando el segundo hizo `git push`, el primero ya había subido cambios. Al hacer `git push` nos salió un error de 'rejected' porque la rama remota tenía commits que nosotros no teníamos localmente."*

**¿Cómo lo resolvieron?**
> *"Hicimos `git pull origin main`, Android Studio nos mostró el conflicto en el archivo `MainActivity.kt` con las marcas `<<<<<<< HEAD`. Decidimos en videollamada qué versión del código quedaba mejor, la unimos manualmente, hicimos `git add .`, `git commit` y luego `git push`. Desde ahí nos acostumbramos a hacer `git pull` siempre antes de empezar a escribir."*

### Dificultad 2: [Ejemplo: Dependencias que no compilaban en el compañero]

**¿Qué pasó?**
> *"Cuando el compañero clonó el repo y abrió el proyecto, Gradle no sincronizaba porque tenía una versión diferente del Android Gradle Plugin."*

**¿Cómo lo resolvieron?**
> *"Actualizamos ambos a la misma versión de Android Studio y del Gradle Plugin. También agregamos `local.properties` al `.gitignore` para evitar que la ruta del SDK local cause problemas."*

---

## 🎯 Reto final: Mensaje visible cuando el login falla

**Descripción del reto:**
Agregar un mensaje visible en pantalla (por ejemplo un `Toast`) que aparezca si el login falla, como cuando la contraseña es incorrecta. Con la contraseña correcta, la app debe seguir funcionando igual que antes.

**¿Cómo lo resolvieron?**

> Escribe aquí un párrafo explicando qué parte del código tocaron y por qué decidieron hacerlo así.
>
> **Ejemplo:**
> *"Resolvimos el reto modificando la función `attemptLogin()` en `MainActivity.kt`. Cuando la respuesta de Retrofit no es exitosa (`response.isSuccessful == false`), mostramos un `Toast` con el mensaje 'Login fallido: credenciales incorrectas' y hacemos visible un `TextView` de error (`tvError`) que antes estaba oculto (`visibility = View.GONE`). Elegimos esta combinación porque el `Toast` cumple con el requerimiento de ser un mensaje visible en pantalla, y el `TextView` persistente le da al usuario una señal clara de que algo salió mal sin depender de que lea el Logcat. También manejamos el caso de excepción de red (catch) con otro `Toast` para que el usuario sepa si el problema es de conexión o de credenciales."*

---

## 📊 Commits por integrante

| Integrante | Cantidad de commits | Enlace al perfil de GitHub |
|------------|---------------------|----------------------------|
| [Cristian Lubo]  | 7+ | [@cristianlubo-00](https://github.com/cristianlubo-00) |
| [Camilo Andres Luna] | 7+ | [@ANdresL2525](https://github.com/AndresL2525) |
| [Juan David] | 7+ | [@ANdresL2525](https://github.com/JDquintero1002) |

**Nota: Tanto cristian lubo (cristianlubo-00) como Andres Luna (AndresL2525) no aparecen en los comits debedido a que estamos trabajando en otros computadores y estos ya tenian unos usario predeterminados**

---

## 🧪 API utilizada

- **URL base:** `https://tu-api-ejemplo.com/api/`
- **Endpoints:**
  - `POST /auth/login` — recibe `username` y `password`, devuelve un `token`.
  - `GET /auth/me` — requiere header `Authorization: Bearer <token>`, devuelve datos del usuario (`id`, `name`, `email`).

---

## 🏗️ Tecnologías y librerías

- [Kotlin](https://kotlinlang.org/)
- [Retrofit 2](https://square.github.io/retrofit/)
- [Gson](https://github.com/google/gson)
- [OkHttp Logging Interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor)
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
- [View Binding](https://developer.android.com/topic/libraries/view-binding)
- [SharedPreferences](https://developer.android.com/training/data-storage/shared-preferences)

---

## 📸 Capturas de pantalla (opcional)

> Puedes agregar aquí screenshots de la app funcionando:
> - Pantalla de login
> - Pantalla de perfil con datos del usuario
> - Toast de error cuando la contraseña es incorrecta

---

## ✅ Checklist de entrega

- [x] Repositorio compartido en GitHub con ambos integrantes como colaboradores.
- [x] Mínimo 7 commits por persona con mensajes descriptivos.
- [x] Guía base completa (pasos 1–8).
- [x] Extensión completa (EditText, TextView, SharedPreferences).
- [x] Reto final resuelto (Toast visible en login fallido).
- [x] README.md con toda la documentación requerida.
- [x] Respuestas individuales a las 5 preguntas de cierre (entregadas por separado).

---

> *Proyecto desarrollado como parte del reto colaborativo de programación en pareja.*
