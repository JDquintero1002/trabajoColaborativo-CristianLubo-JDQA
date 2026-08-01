# 📱 LoginApp — Consumir una API con Token en Android (Kotlin)

> **Reto colaborativo · Fase 2** — Programar en pareja

---

## 👥 Equipo
 
| Rol | Nombre | Salón | GitHub |
|-----|--------|-------|--------|
| 🏗️ Creador del repositorio | **Juan David** | ADSO 1 | [@JDquintero1002](https://github.com/JDquintero1002) |
| 🖥️ Colaborador (clonó el repo) | **Cristian Lubo** | ADSO 3 | [@cristianlubo-00](https://github.com/cristianlubo-00) |
| 🖥️ Colaborador (clonó el repo) | **Camilo Andrés Luna** | ADSO 3 | [@AndresL2525](https://github.com/AndresL2525) |


---

## 🗂️ ¿Cómo se organizaron?

**Opción elegida:** B — División por paso + revisión cruzada

**¿Por qué eligieron esa opción?**

> Elegimos la Opción B (División por paso + revisión cruzada) porque fue la mejor opción dado el tiempo disponible y para prevenir posibles errores que se pueden dar cuando se trabaja en un mismo archivo (como en la Opción A). Cada integrante se encargó de pasos específicos de la guía, hizo push de su parte, y al final revisamos el trabajo del otro para corregir o completar antes de entregar.

---

## 🛠️ Avance por la guía base

Recorrimos los 8 pasos de la guía base juntos, siguiendo el esquema de organización que elegimos:

| Paso | Descripción | Quién escribió el código | Commit representativo |
|------|-------------|--------------------------|----------------------|
| 1 | Conocer la API (endpoints, login, token) | Ambos (lo revisamos juntos en pantalla compartida) | — |
| 2 | Crear el proyecto y permiso de Internet | Juan David | `creación del proyecto, configuracion decarpeta .idea y rama main y developer` |
| 3 | Agregar dependencias (Retrofit, Gson, OkHttp, corrutinas) | Juan David | `configuración del gradel` |
| 4 | Modelar los datos (data classes) | Juan David | `creacion de archivos necesario` |
| 5 | Declarar los endpoints (interfaz) | Juan David | `agregue todo el codigo a las clases, objetos e interfaces correspondientes` |
| 6 | Construir el cliente Retrofit | Juan David | `agregue todo el codigo a las clases, objetos e interfaces correspondientes` |
| 7 | Unir todo: login → guardar token → pedir datos | Juan David | `actualizacion del mainActivity` |
| 8 | Probar y leer el resultado en el Logcat | Todos | `Correcion de errores, confirmacion y se confirma resultadao esperado en logcat` |

---

## ➕ Avance por la extensión

| Mejora | Descripción | Quién lo hizo | Commit representativo |
|--------|-------------|---------------|----------------------|
| **EditText + botón** | Reemplazamos las credenciales fijas por dos `EditText` (usuario y contraseña) y un botón "Ingresar". | Cristian Lubo | `fix archivo readme y xml` |
| **Mostrar en pantalla** | Agregamos un `TextView` para mostrar nombre, correo y un mensaje visible si el login falla (en lugar de solo dejarlo en Logcat). | Cristian Lubo | `fix colors y ic_user` |
| **SharedPreferences** | Guardamos el token en `SharedPreferences` para que, al volver a abrir la app, si ya hay sesión guardada se salte el formulario y pida directo los datos del usuario. | Juan David | `actualizacion del mainActivity` |
| **Diseño Material** | Ajustamos botones, colores e iconos para darle una apariencia más profesional con Material Design. | Cristian Lubo | `feat ajustes de botton` |
| **Corrección final** | Corrección de errores en el login y confirmación de funcionamiento de la app. | Juan David | `creacion del xml, correccion de errores y confirmación de funcion de la app` |


---

## ⚠️ Dificultades al sincronizar e integrar el trabajo

### Dificultad 1: Commits con usuario equivocado

**¿Qué pasó?**
> Al trabajar en diferentes computadores del salón, los commits de Cristian se subieron con el usuario `@Froshi-iuri` en vez de su usuario personal de GitHub. Esto pasó porque esas máquinas ya tenían configurado un usuario de Git global diferente.

**¿Cómo lo resolvieron?**
> Identificamos que los commits de `@Froshi-iuri` correspondían a Cristian Lubo. Documentamos esto en el README para que el profesor pueda verificar que todos los integrantes participaron. Para futuros proyectos, configuramos el usuario local del repositorio con `git config user.name` y `git config user.email` antes de hacer commits.

### Dificultad 2: Merge conflicts al integrar ramas

**¿Qué pasó?**
> Creamos ramas individuales (`Cristian`, `Andres`, `developer`) para que cada quien trabajara sin pisar el código del otro. Al hacer los merge pull requests (#1, #2, #3 y #5), hubo conflictos en `MainActivity.kt` y en `activity_main.xml` porque ambos estábamos tocando los mismos archivos.

**¿Cómo lo resolvieron?**
> Revisamos los conflictos en GitHub y en Android Studio, decidimos en videollamada qué versión del código quedaba mejor, la unimos manualmente y hicimos los merges. Después de eso, empezamos a coordinar mejor quién tocaba qué archivo en cada momento.

### Dificultad 3: Dependencias y versiones de Gradle

**¿Qué pasó?**
> Al clonar el repo en diferentes computadores, Gradle no sincronizaba correctamente porque había diferencias en las versiones del Android Gradle Plugin y del SDK.

**¿Cómo lo resolvieron?**
> Actualizamos Android Studio a la misma versión en todos los equipos, sincronizamos el `build.gradle` del proyecto y agregamos `local.properties` al `.gitignore` para evitar que la ruta local del SDK cause problemas al clonar.

---

## 🎯 Reto final: Mensaje visible cuando el login falla

**Descripción del reto:**
Agregar un mensaje visible en pantalla (por ejemplo un `Toast`) que aparezca si el login falla, como cuando la contraseña es incorrecta. Con la contraseña correcta, la app debe seguir funcionando igual que antes.

**¿Cómo lo resolvieron?**

> Resolvimos el reto modificando la función `attemptLogin()` en `MainActivity.kt`. Cuando la respuesta de Retrofit no es exitosa (`response.isSuccessful == false`), mostramos un `Toast` con el mensaje "Login fallido: credenciales incorrectas" y hacemos visible una `MaterialCardView` de error (`cardError`) que antes estaba oculta (`visibility = View.GONE`). Elegimos esta combinación porque el `Toast` cumple con el requerimiento de ser un mensaje visible en pantalla, y la tarjeta persistente le da al usuario una señal clara de que algo salió mal sin depender de que lea el Logcat. También manejamos el caso de excepción de red (catch) con otro `Toast` para que el usuario sepa si el problema es de conexión o de credenciales.

---

## 📊 Commits por integrante

| Integrante | Cantidad de commits | Enlace al perfil de GitHub |
|------------|---------------------|----------------------------|
| Juan David | **11** | [@JDquintero1002](https://github.com/JDquintero1002) |
| Cristian Lubo | **8** | [@cristianlubo-00](https://github.com/cristianlubo-00) |
| Camilo Andrés Luna | **8** | [@AndresL2525](https://github.com/AndresL2525) |

> **Nota sobre los commits:** Al trabajar en diferentes computadores del salón, los commits de Cristian Lubo aparecen bajo el usuario `@Froshi-iuri` porque esas máquinas tenían un usuario de Git global preconfigurado. Los commits de `@Froshi-iuri` corresponden a Camilo Andrés Luna.
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
- [Material Design Components](https://m3.material.io/)

---

## 📸 Capturas de pantalla

> Puedes agregar aquí screenshots de la app funcionando:
> - Pantalla de login con diseño Material
> - Pantalla de perfil con datos del usuario
> - Toast de error cuando la contraseña es incorrecta
> - Tarjeta de error en login fallido

---

## ✅ Checklist de entrega

- [x] Repositorio compartido en GitHub con todos los integrantes como colaboradores.
- [x] Mínimo 7 commits por persona con mensajes descriptivos.
- [x] Guía base completa (pasos 1–8).
- [x] Extensión completa (EditText, TextView, SharedPreferences, diseño Material).
- [x] Reto final resuelto (Toast visible en login fallido).
- [x] README.md con toda la documentación requerida.
- [x] Respuestas individuales a las 5 preguntas de cierre (entregadas por separado).


# Respuestas de Cierre — Reto Colaborativo

---
# Respuestas Individuales — Camilo Andres Luna
## 1. Predicción

Si cambiamos `@GET("auth/me")` por `@GET("auth/mee")`, el servidor no va a encontrar esa dirección porque no existe. El error sería **404 Not Found**.

Aparecería en el Logcat como `HTTP FAILED: 404`, y en la app se activaría el mensaje de error que hicimos en el reto final (la tarjeta roja que dice que algo falló).

---

## 2. Depuración

**Causa 1:** El token no se está mandando bien en el encabezado. Si olvidamos poner `"Bearer "` antes del token, el servidor no lo reconoce y responde 401.

**Causa 2:** El token ya expiró. Algunos tokens duran poco tiempo (como 15 minutos). Si pasó mucho tiempo entre el login y pedir los datos, el servidor dice que no es válido.

---

## 3. Transferencia

Un ejemplo es **Instagram**. Haces login una vez y no te pide la contraseña de nuevo porque guarda un token.

Ese token "vive" en el celular, guardado de forma segura (cifrado), normalmente en algo llamado **EncryptedSharedPreferences** o el **Keystore** del teléfono. Así, aunque alguien agarre tu celular, no puede leerlo fácilmente.

Otro ejemplo es **Spotify**: inicias sesión y puedes escuchar música durante días sin volver a escribir tu contraseña.

---

## 4. Lectura de código

`getCurrentUser` recibe el token como parámetro porque así la función **no depende de nada externo**. Solo necesita que le pasen el token y ya.

Esto tiene dos ventajas:
- Se puede probar más fácilmente (le pasas un token de prueba y listo).
- Se puede usar desde cualquier parte de la app sin depender de SharedPreferences ni de variables globales.

Si leyera el token directamente de dentro de la función, estaría "amarrada" a una sola forma de obtenerlo y sería más difícil de reutilizar.

---

## 5. Justificación de diseño

El riesgo de guardar el token en SharedPreferences sin cifrar es que **cualquiera puede leerlo** si tiene acceso al celular.

Por ejemplo:
- Si el celular tiene acceso root, una app maliciosa puede abrir el archivo donde se guarda y leer el token en texto plano.
- Si se hace un backup de la app a la nube, el token viaja sin protección.
- Con ese token, un atacante puede hacerse pasar por el usuario y usar la API como si fuera él.

En una app real se debería usar **EncryptedSharedPreferences** o el **Android Keystore**, que cifran el token antes de guardarlo.


# Respuestas Individuales — Cristian Lubo


## 1. Predicción

Si cambian `@GET("auth/me")` por `@GET("auth/mee")` (un typo), el servidor no encuentra esa dirección porque no existe. El error sería **404 Not Found**.

Ese error aparecería en el Logcat como `HTTP FAILED: 404`, y en la app se activaría el mensaje de error que hicimos en el reto final.

---

## 2. Depuración

Las dos causas más probables son:

- **Que el token no se esté enviando junto con la petición.** Si no se manda bien en el header, el servidor no reconoce al usuario y responde 401.
- **Que el token ya no sirva porque venció o se guardó mal.** Algunos tokens duran poco tiempo, entonces si pasó mucho rato entre el login y pedir los datos, el servidor dice que no es válido.

---

## 3. Transferencia

Un ejemplo sería **Nequi**. Cuando iniciamos sesión, la aplicación guarda un token en el celular y ese token se utiliza para comprobar que somos nosotros cada vez que hacemos una transferencia o vemos nuestros movimientos, sin tener que volver a iniciar sesión. El token queda guardado dentro de la aplicación en el dispositivo para que la sesión se mantenga activa.

---

## 4. Lectura de código

`getCurrentUser` recibe el token como parámetro porque así la función es más fácil de usar, pero necesita que le envíen el token y puede funcionar sin depender de una variable que esté en otra parte del programa.

Si leyera el token directamente desde adentro, estaría amarrada a una sola forma de obtenerlo y no se podría reutilizar tan fácil.

---

## 5. Justificación de diseño

Si alguien logra entrar a los archivos de la aplicación, podría ver el token y usarlo para entrar a la cuenta del usuario sin necesidad de saber la contraseña. Por eso en una app real se debería guardar el token cifrado.

---



