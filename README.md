# 📱 LoginApp — Consumir una API con Token en Android (Kotlin)

> **Reto colaborativo · Fase 2** — Programar en pareja

---

## 👥 Equipo

| Rol | Nombre | Salón | GitHub |
|-----|--------|-------|--------|
| 🏗️ Creador del repositorio | **Juan David** | ADSO 1 | [@JDquintero1002](https://github.com/JDquintero1002) |
| 🖥️ Colaborador (clonó el repo) | **Cristian Lubo** | ADSO 3 | [@cristianlubo-00](https://github.com/cristianlubo-00) |
| 🖥️ Colaborador (clonó el repo) | **Camilo Andrés Luna** | ADSO 3 | [@AndresL2525](https://github.com/AndresL2525) |

> **Nota:** Algunos commits aparecen bajo el usuario `@Froshi-iuri` porque trabajamos en diferentes computadores que tenían usuarios de Git preconfigurados. Los commits de `@Froshi-iuri` corresponden a Andres luna.

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
| 2 | Crear el proyecto y permiso de Internet | Juan David | `creacion de archivos necesario` |
| 3 | Agregar dependencias (Retrofit, Gson, OkHttp, corrutinas) | Juan David | `creacion de archivos necesario` |
| 4 | Modelar los datos (data classes) | Juan David | `agregue todo el codigo a las clases, objetos e interfaces correspondientes` |
| 5 | Declarar los endpoints (interfaz) | Juan David | `agregue todo el codigo a las clases, objetos e interfaces correspondientes` |
| 6 | Construir el cliente Retrofit | Juan David | `agregue todo el codigo a las clases, objetos e interfaces correspondientes` |
| 7 | Unir todo: login → guardar token → pedir datos | Juan David | `actualizacion del mainActivity` |
| 8 | Probar y leer el resultado en el Logcat | Todos | `Correcion de errores, confirmacion y se confirma resultado esperado` |

---

## ➕ Avance por la extensión

| Mejora | Descripción | Quién lo hizo | Commit representativo |
|--------|-------------|---------------|----------------------|
| **EditText + botón** | Reemplazamos las credenciales fijas por dos `EditText` (usuario y contraseña) y un botón "Ingresar". | Cristian Lubo | `fix archivo readme y xml` |
| **Mostrar en pantalla** | Agregamos un `TextView` para mostrar nombre, correo y un mensaje visible si el login falla (en lugar de solo dejarlo en Logcat). | Cristian Lubo | `fix colors y ic_user` |
| **SharedPreferences** | Guardamos el token en `SharedPreferences` para que, al volver a abrir la app, si ya hay sesión guardada se salte el formulario y pida directo los datos del usuario. | Juan David | `actualizacion del mainActivity` |
| **Diseño Material** | Ajustamos botones, colores e iconos para darle una apariencia más profesional con Material Design. | Cristian Lubo | `feat ajustes de botton` |

---

## 📜 Historial de commits

A continuación el historial real de commits del repositorio:

| # | Autor | Hash | Mensaje |
|---|-------|------|---------|
| 1 | Juan David | `b315be8` | creacion de archivos necesario |
| 2 | Juan David | `7dee787` | agregue todo el codigo a las clases, objetos e interfaces correspondientes |
| 3 | Juan David | `60a83ff` | Merge pull request #1 from JDquintero1002/Cristian |
| 4 | Cristian Lubo | `3441277` | feat archivo readme |
| 5 | Juan David | `d27d66f` | actualizacion del mainActivity |
| 6 | Juan David | `b789af4` | Correcion de errores, confirmacion y se confirma resultado esperado |
| 7 | Juan David | `977de2c` | Merge pull request #2 from JDquintero1002/Cristian |
| 8 | Cristian Lubo | `bbb6c1b` | Merge branch 'developer' |
| 9 | Cristian Lubo | `e62be86` | fix archivo readme y xml |
| 10 | Cristian Lubo | `fa617b5` | fix colors y ic_user |
| 11 | Cristian Lubo | `cba47a7` | feat ajustes de botton |
| 12 | Juan David | `a6a1015` | Merge pull request #3 from JDquintero1002/Andres |
| 13 | Cristian Lubo | `06abd57` | fix login |
| 14 | Cristian Lubo | `534...` | Merge branch 'developer' |

---

## ⚠️ Dificultades al sincronizar e integrar el trabajo

### Dificultad 1: Commits con usuario equivocado

**¿Qué pasó?**
> Al trabajar en diferentes computadores del salón, algunos commits se subieron con el usuario `@Froshi-iuri` en vez del usuario personal de GitHub de Cristian. Esto pasó porque esas máquinas ya tenían configurado un usuario de Git global diferente.

**¿Cómo lo resolvieron?**
> Identificamos que los commits de `@Froshi-iuri` correspondían a Cristian Lubo. Documentamos esto en el README para que el profesor pueda verificar que todos los integrantes participaron. Para futuros proyectos, configuramos el usuario local del repositorio con `git config user.name` y `git config user.email` antes de hacer commits.

### Dificultad 2: Merge conflicts al integrar ramas

**¿Qué pasó?**
> Creamos ramas individuales (`Cristian`, `Andres`,`JDQA`,`developer`) para que cada quien trabajara sin pisar el código del otro. Al hacer los merge pull requests (#1, #2 y #3), hubo conflictos en `MainActivity.kt` y en `activity_main.xml` porque ambos estábamos tocando los mismos archivos.

**¿Cómo lo resolvieron?**
> Revisamos los conflictos en GitHub y en Android Studio, decidimos qué versión del código quedaba mejor, la unimos manualmente y hicimos los merges. Después de eso, empezamos a coordinar mejor quién tocaba qué archivo en cada momento.

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
| Juan David | 7 | [@JDquintero1002](https://github.com/JDquintero1002) |
| Cristian Lubo | 7 | [@cristianlubo-00](https://github.com/cristianlubo-00) |
| Camilo Andrés Luna | Participó en revisión y testing | [@AndresL2525](https://github.com/AndresL2525) |

> **Nota:** Tanto Cristian Lubo (`cristianlubo-00`) como Camilo Andrés Luna (`AndresL2525`) no aparecen directamente en algunos commits debido a que estábamos trabajando en otros computadores que ya tenían un usuario de Git predeterminado (`@Froshi-iuri`). Los commits de `@Froshi-iuri` corresponden a Cristian Lubo.

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

---

> *Proyecto desarrollado como parte del reto colaborativo de programación en pareja.*

RESPUESTAS INDIVIDUALES: 
Juan David Quintero 
1.	Predicción
Si cambian @GET("auth/me") por @GET("auth/mee") (un typo), ¿qué error esperarían ver y en qué parte del código aparecería?
Rta: Se puede esperar ver un error  de servidor 404, porque la ruta "auth/mee" no existe en la API, ese error aparecía en la respuesta de la petición
2.	Depuración
"Recibo error 401 al pedir los datos del usuario, pero el login sí funcionó." ¿Cuáles son las dos causas más probables?
Rta: El token no se envió bien en el encabezado o el token caduco o no exite
3.	Transferencia
¿En qué otras apps que usan a diario reconocen este mismo patrón de login → token → petición protegida? Den un ejemplo y expliquen dónde "vive" el token ahí.
Rta: Instagram. Cuando abro la app e inicio sesión, no me vuelve a pedir la contraseña cada vez que pongo una publicación o en caso de buscar algo. El token queda guardado localmente en el almacenamiento del teléfono o desde el navegador y la app valida automáticamente.
4.	Lectura de código
¿Por qué getCurrentUser recibe el token como parámetro en vez de leerlo directamente de una variable dentro de la función?
Rta: 
Porque así funciona mas limpia y flexible. En lugar de obligar a getCurrentUser  a saber de donde sacar el token y simplemente pasamos el dato que necesita.
5.	Justificación de diseño
¿Qué riesgo ven en guardar el token en SharedPreferences sin cifrar? (no se espera que lo resuelvan, solo que lo identifiquen).
Rta:
El riego principal es de seguridad: si los archivos del teléfono quedan expuestos en un celular rooteado o mediante herramientas de inspección de apps, cualquiera podría leer el token en el texto plano. Copiarlo y usarlo para meterse en cuentas desde otro lado sin saber la contraseña 

