package com.example.vista;

import java.util.List;
import java.util.Scanner;

import com.example.controlador.AlumnoControlador;
import com.example.modelo.Alumno;

public class AlumnoView {

    public static final int OPCION_CREAR_ALUMNO = 1;
    public static final int OPCION_MOSTRAR_ALUMNOS = 2;
    public static final int OPCION_CERRAR_PROGRAMA = 3;
    private final Scanner scanner = new Scanner(System.in);
    private final AlumnoControlador controlador;

    private void abrirMenu() {
        System.out.println(OPCION_CREAR_ALUMNO + ". Crear Alumno");
        System.out.println(OPCION_MOSTRAR_ALUMNOS + ". Mostrar Alumno");
        System.out.println(OPCION_CERRAR_PROGRAMA + ". Cerrar programa");
        System.out.println("Por favor seleccione una opción:");
    }

    public void menu() {
        boolean salir = true;
        while (salir) {
           abrirMenu();
            String opciontexto = scanner.nextLine();
            int opcion;
            try {
                opcion = Integer.parseInt(opciontexto);
            } catch (NumberFormatException e) {
                System.out.println("Opcion no valida, introduce un número");
                continue;
            }
            switch (opcion) {
                case OPCION_CREAR_ALUMNO:
                    crearAlumno();
                    break;
                case OPCION_MOSTRAR_ALUMNOS:
                    mostrarAlumno();
                    break;
                case OPCION_CERRAR_PROGRAMA:
                    System.out.println("Cerrando programa");
                    salir = false;
                    break;

                default:
                    System.out.println("Opción no disposible, por favor seleccione una opción válida");

            }
        }
    }
    public AlumnoView(AlumnoControlador controlador) {
        this.controlador = controlador;
    }

    private String solicitarDato(String dato) {
        System.out.println("Por favor imgrese el " + dato + " del alumno:");
        return scanner.nextLine();
    }

    private int solicitarEdad() {
        while (true) {
            String edadtexto = solicitarDato("edad");
            try {
                return Integer.parseInt(edadtexto);
            } catch (NumberFormatException e) {
                System.out.println("Edad no valida, introduce un número válido");
            }
        }
    }

    public void crearAlumno() {
        String nombre = solicitarDato("nombre");
        String apellido = solicitarDato("apellido");
        int edad = solicitarEdad();
        while (true) {
            try {
                controlador.agregarAlumno(nombre, apellido, edad);
                System.out.println("Alumno creado");
                break; // salir del bucle
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                return;
            }

        }
    }

    public void mostrarAlumno() {
        List<Alumno> alumnos = controlador.obtenerAlumnos();
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos");
        } else {
            for (Alumno a1 : alumnos) {
                System.out.println(a1.toString());

            }
        }
    }
}
