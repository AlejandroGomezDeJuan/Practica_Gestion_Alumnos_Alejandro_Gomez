package com.example.controlador;

import java.util.List;

import com.example.interfaz.AlumnoInterfaz;
import com.example.modelo.Alumno;

public class AlumnoControlador {

    private final AlumnoInterfaz interfaz;

    public AlumnoControlador(AlumnoInterfaz interfaz) {
        this.interfaz = interfaz;
    }

    public List<Alumno> obtenerAlumnos() {
        return interfaz.listar();
    }

    public void agregarAlumno(String nombre, String apellido, int edad) {
        if (nombre == null || nombre.isEmpty()
                || apellido == null || apellido.isEmpty()
                || edad <= 0) {
            throw new IllegalArgumentException("Datos no válidos");
        }

        Alumno alumno = new Alumno(nombre, apellido, edad);
        interfaz.insertar(alumno);
    }

}
