package com.example.controlador;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.modelo.Alumno;
import com.example.modelo.AlumnoModelo;

public class ModeloTest {

    private AlumnoModelo modelo;

    @BeforeEach
    void setUp() {
        modelo = new AlumnoModelo();
    }

   @Test
    void agregarAlumno() {
    Alumno alumno = new Alumno("Alejandro", "Gomez", 19);
    modelo.insertar(alumno);

    List<Alumno> alumnos = modelo.listar();

    assertEquals(1, alumnos.size());
    assertEquals("Alejandro", alumnos.get(0).getNombre());
    assertEquals("Gomez", alumnos.get(0).getApellido());
    assertEquals(19, alumnos.get(0).getEdad());
}

    @Test
void agregarMultiplesAlumnos() {
    Alumno a1 = new Alumno("Alejandro", "Gomez", 19);
    Alumno a2 = new Alumno("Sara", "Gomez", 17);

    modelo.insertar(a1);
    modelo.insertar(a2);

    List<Alumno> alumnos = modelo.listar();

    assertEquals(2, alumnos.size());

    assertEquals("Alejandro", alumnos.get(0).getNombre());
    assertEquals("Gomez", alumnos.get(0).getApellido());
    assertEquals(19, alumnos.get(0).getEdad());

    assertEquals("Sara", alumnos.get(1).getNombre());
    assertEquals("Gomez", alumnos.get(1).getApellido());
    assertEquals(17, alumnos.get(1).getEdad());
}

    
    @Test
    void agregarAlumnoConNombreVacio() {
    Alumno alumno = new Alumno("", "Gomez", 19);
    modelo.insertar(alumno);
    List<Alumno> alumnos = modelo.listar();
    assertEquals("", alumnos.get(0).getNombre());
}

@Test
    void agregarAlumnoDuplicado() {
    Alumno alumno = new Alumno("Ana", "Lopez", 18);
    modelo.insertar(alumno);
    modelo.insertar(alumno); // mismo objeto

    List<Alumno> alumnos = modelo.listar();
    assertEquals(2, alumnos.size()); // o 1 si se evita duplicado
}

    
}
