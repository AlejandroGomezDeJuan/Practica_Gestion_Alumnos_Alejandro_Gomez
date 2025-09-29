package com.example.modelo;

import java.util.ArrayList;
import java.util.List;

import com.example.interfaz.AlumnoInterfaz;

public class AlumnoModelo implements AlumnoInterfaz {

    private final List<Alumno> alumnos;

    public AlumnoModelo() {
        this.alumnos = new ArrayList<>();
    }

    @Override
    public void insertar(Alumno a1) {
        alumnos.add(a1);
    }

    @Override
    public List<Alumno> listar() {
        return new ArrayList<>(alumnos);
    }
}
