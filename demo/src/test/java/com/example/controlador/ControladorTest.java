package com.example.controlador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.interfaz.AlumnoInterfaz;
import com.example.modelo.Alumno;

@ExtendWith(MockitoExtension.class) 
public class ControladorTest {

    @Mock
    AlumnoInterfaz mockModelo;

    @InjectMocks
    AlumnoControlador controlador;

   @Test
void testObtenerAlumnos() {
    Alumno alumnoSimulado = new Alumno("Alejandro", "Gomez", 19);
    List<Alumno> listaSimulada = new ArrayList<>();
    listaSimulada.add(alumnoSimulado);

    when(mockModelo.listar()).thenReturn(listaSimulada);

    List<Alumno> resultado = controlador.obtenerAlumnos();

    verify(mockModelo).listar();

    assertEquals(1, resultado.size());
    assertEquals("Alejandro", resultado.get(0).getNombre());
    assertEquals("Gomez", resultado.get(0).getApellido());
    assertEquals(19, resultado.get(0).getEdad());
}


    @Test
    void testAgregarAlumno() {
        controlador.agregarAlumno("Ana", "García", 22);
        verify(mockModelo).insertar(any(Alumno.class));
    }

    @Test
    void testObtenerAlumnosVacio() {
    when(mockModelo.listar()).thenReturn(Arrays.asList());

    List<Alumno> resultado = controlador.obtenerAlumnos();

    assertEquals(0, resultado.size());
    verify(mockModelo).listar();
}

    @Test
    void testAgregarAlumnoDatosInvalidos() {
        try {
            controlador.agregarAlumno("", "García", 22);
        } catch (IllegalArgumentException e) {
            assertEquals("Datos del alumno inválidos", e.getMessage());
        }

        try {
            controlador.agregarAlumno("Ana", "", 22);
        } catch (IllegalArgumentException e) {
            assertEquals("Datos del alumno inválidos", e.getMessage());
        }

        try {
            controlador.agregarAlumno("Ana", "García", -5);
        } catch (IllegalArgumentException e) {
            assertEquals("Datos del alumno inválidos", e.getMessage());
        }

        // Verificamos que no se llamó al método insertar del mock
        verify(mockModelo, org.mockito.Mockito.never()).insertar(any(Alumno.class));
    }

}

