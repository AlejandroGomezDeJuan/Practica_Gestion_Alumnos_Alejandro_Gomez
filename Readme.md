
# PRÁCTICA DE GESTIÓN DE ALUMNOS - ALEJANDRO GÓMEZ DE JUAN

- En esta práctica vamos a crear una aplicación dedicada a la gestión de datos relacionados con alumnos, donde insertaremos un nombre, un apellido y la edad del alumno.

Vamos a utilizar tres partes.

1. **Modelo**
2. **Vista**
1. **Controlador**

Vamos a pasar a explicar los archivos que vamos a utilizar:

---

## ARCHIVO: MODELO

Clase que implementa la interfaz `AlumnoInterfaz` y administra en memoria la lista de alumnos.

1. Mantiene una colección interna de objetos `Alumno`.  
2. El método `insertar()` agrega un nuevo alumno a la lista.  
3. El método `listar()` devuelve una copia de la lista actual de alumnos.

---

## ARCHIVO: VISTA

Clase encargada de mostrar el menú de opciones al usuario y gestionar la interacción por consola.

1. Muestra un menú con tres opciones: crear alumno, mostrar alumnos y cerrar el programa.  
2. Permite ingresar los datos de un alumno (nombre, apellido y edad) y los envía al controlador para su registro.  
3. Recupera la lista de alumnos desde el controlador y la imprime en consola.  
4. Valida entradas numéricas y muestra mensajes de error si los datos son incorrectos.  
5. Mantiene el flujo del programa hasta que el usuario decide salir.

---

## ARCHIVO: CONTROLADOR

Clase que actúa como intermediario entre la vista y el modelo, gestionando la lógica de negocio relacionada con los alumnos. En esta clase he utilizado el codigo de Alejandro porque me estaba creando problemas y al ver el suyo me iba bien.

1. Recibe una instancia de `AlumnoInterfaz`, que representa el modelo encargado de almacenar los datos.  
2. El método `obtenerAlumnos()` solicita al modelo la lista actual de alumnos registrados.  
3. El método `agregarAlumno()` valida los datos ingresados (nombre, apellido y edad) antes de crear un nuevo alumno y enviarlo al modelo.  
4. Si los datos son inválidos, lanza una excepción para evitar registros incorrectos.


---

## ARCHIVO: INTERFAZ

Interfaz que define operaciones para la entidad `Alumno`.

## Métodos
- **insertar(Alumno alumno)**: Agrega un alumno.  
- **listar()**: Devuelve una lista de alumnos.


---

## ARCHIVO: APP.JAVA

Este archivo es el punto de partida de la aplicación. Aquí se conectan los tres componentes principales del sistema de alumnos:

1. Se crea el modelo (`AlumnoModelo`), encargado de gestionar y almacenar los datos de los alumnos.  
2. Se instancia el controlador (`AlumnoControlador`), que recibe el modelo y se encarga de coordinar la lógica entre los datos y la vista.  
3. Se prepara la vista (`AlumnoView`), que utiliza el controlador para interactuar con el usuario.  
4. Finalmente, se ejecuta el método `menu()` de la vista, que muestra las opciones disponibles y permite al usuario navegar por el sistema.  

---

## Test realizados con Mockito

1. **testObtenerAlumnos**: Verifica que el controlador obtiene correctamente una lista de alumnos simulada desde el modelo y que los datos coinciden.

2. **testAgregarAlumno**: Comprueba que al agregar un alumno válido, el controlador llama al método insertar del modelo con un objeto Alumno.

3. **testObtenerAlumnosVacio**: Simula una lista vacía en el modelo y verifica que el controlador la maneja correctamente sin errores.

4. **testAgregarAlumnoDatosInvalidos** : Valida que el controlador lanza una excepción cuando se intenta agregar un alumno con datos inválidos (nombre vacío, apellido vacío o edad negativa), y que no se llama al método insertar.

---

### Test realizados con JUnit
1. **agregarAlumno**: Verifica que al insertar un alumno, sus datos se almacenan correctamente en el modelo.

2. **agregarMultiplesAlumnos**: Comprueba que se pueden insertar varios alumnos y que se mantienen sus datos y el orden de inserción.

3. **agregarAlumnoConNombreVacio**: Valida que el modelo acepta un alumno con el nombre vacío y lo guarda tal cual.

4. **agregarAlumnoDuplicado**:Testea que el modelo permite insertar el mismo objeto alumno más de una vez, resultando en duplicados.

