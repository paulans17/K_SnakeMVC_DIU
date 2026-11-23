# 🐍 SnakeMVC

El Snake de toda la vida hecho en **Java + Swing** y montado con el patrón **Modelo-Vista-Controlador**. Lo hice para la asignatura de **Diseño de Interfaces de Usuario (DIU)**, en 2º del Grado en Ingeniería Informática de Servicios y Aplicaciones (UVa, campus de Segovia).

La gracia no era solo que el juego funcionase. También tenía que ser **usable y accesible**, así que además de jugar tiene configuración, ranking, tutorial y un modo para daltónicos.

## Qué tiene

- **Menú principal**: Jugar, Configuración, Ranking y Ayuda.
- **Configuración**:
  - velocidad de 1 a 10 con un slider
  - tablero pequeño, medio o grande (10×10, 15×15 o 20×20)
  - **modo daltónico**
- **Modo daltónico**: cambia la paleta (serpiente cian y fruta naranja sobre fondo gris oscuro en vez de verde y rojo) para que se distingan bien con los tipos de daltonismo más comunes.
- **Puntuación por rapidez**: cuanto antes te comes la fruta, más puntos te llevas. Cada vez que comes sale un aviso con lo que has sumado (`+70`, `+50`…).
- **Ranking Top 5 persistente**: si entras en el top te pide tus iniciales (3 letras, estilo arcade) y se guarda en `ranking.txt`, así que no se pierde al cerrar.
- **Tutorial** con los controles y las reglas.

## Cómo está organizado (MVC)

```
src/
├── modelo/        → la lógica del juego, sin nada de interfaz
│   ├── Serpiente, Fruta, Tablero, Direccion
│   ├── Puntuacion
│   └── Configuracion
├── vista/         → las pantallas en Swing (JPanel)
│   ├── VistaMenu, VistaJuego, VistaConfiguracion
│   ├── VistaRanking, VistaTutorial
│   └── ColoresAccesibles   → paletas normal y daltónica
├── controlador/   → une modelo y vista y gestiona la navegación
│   ├── ControladorMenu, ControladorJuego, ControladorConfiguracion
│   ├── ControladorRanking  → lectura y escritura del ranking
│   ├── ControladorTeclado, ControladorTutorial
└── interfaces/    → Controlador y Actualizable
```

Cada pantalla tiene su vista y su controlador, y todos los controladores implementan la misma interfaz `Controlador` (`inicializar()`). Así cambiar de pantalla es simplemente crear el controlador que toca y llamarlo.

## Cómo ejecutarlo

Necesitas **Java 21**, que es con el que está hecho.

**Con IntelliJ IDEA:** abre la carpeta del proyecto y ejecuta `Main.java`.

**Desde la terminal:**

```bash
javac -d out $(find src -name "*.java")
java -cp out Main
```

Ejecútalo desde la raíz del proyecto para que encuentre `ranking.txt`.

## Controles

| Tecla | Acción |
|---|---|
| ↑ ↓ ← → | Mover la serpiente |

Pierdes si chocas contra una pared o contra tu propio cuerpo.

## Tecnologías

Java · Swing · patrón MVC · E/S de ficheros para el ranking
