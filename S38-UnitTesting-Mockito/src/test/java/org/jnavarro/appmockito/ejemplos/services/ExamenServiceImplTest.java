package org.jnavarro.appmockito.ejemplos.services;

import org.jnavarro.appmockito.ejemplos.models.Examen;
import org.jnavarro.appmockito.ejemplos.repositories.ExamenRepository;
import org.jnavarro.appmockito.ejemplos.repositories.PreguntasRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExamenServiceImplTest {
    @Mock
    ExamenRepository repository;
    @InjectMocks
    ExamenServiceImpl service;
    @Mock
    PreguntasRepository preguntasRepository;

    @BeforeEach
    void setUp(){
        //se habilita el uso de anotaciones.
        //MockitoAnnotations.openMocks(this);
//        repository = mock(ExamenRepository.class);
//        preguntasRepository = mock(PreguntasRepository.class);
//        service = new ExamenServiceImpl(repository,preguntasRepository);

    }

    @Test
    void findExamenPorNombre() {

        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        Optional<Examen> examen = service.findExamenPorNombre("Matematicas");

        assertTrue(examen.isPresent());
        assertEquals(5L,examen.orElseThrow().getId());
        assertEquals("Matematicas",examen.get().getNombre());
    }

    @Test
    void findExamenPorNombreListaVacia() {
        List<Examen> datos = Collections.emptyList();

        when(repository.findAll()).thenReturn(datos);
        Optional<Examen> examen = service.findExamenPorNombre("Matematicas");

        assertFalse(examen.isPresent());
    }

    @Test
    void testPreguntasExamen() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntasRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        Examen examen = service.findExamenPorNombreConPreguntas("Matematicas");
        assertEquals(5,examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("INTEGRALES"));
    }

    @Test
    void testPreguntasExamenVerify() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntasRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        Examen examen = service.findExamenPorNombreConPreguntas("Matematicas");
        assertEquals(5,examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("INTEGRALES"));
        verify(repository).findAll();
        verify(preguntasRepository).findPreguntasPorExamenId(5L);
    }

    @Test
    void testNoExisteExamenVerify() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntasRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        Examen examen = service.findExamenPorNombreConPreguntas("Matematicas2");
        assertNull(examen);
        verify(repository).findAll();
        verify(preguntasRepository).findPreguntasPorExamenId(5L);

    }

    @Test
    void testGuardarExamen() {
        //GIVEN
        Examen newExamen = Datos.EXAMEN;
        newExamen.setPreguntas(Datos.PREGUNTAS);

        when(repository.guardar(any(Examen.class))).then(new Answer<Examen>() {
            Long secuencia = 8L;

            @Override
            public Examen answer(InvocationOnMock invocationOnMock) throws Throwable {
                Examen examen = invocationOnMock.getArgument(0);
                examen.setId(secuencia++);
                return examen;
            }
        });
        //WHEN
        Examen examen = service.guardar(newExamen);

        //THEN
        assertNotNull(examen.getId());
        assertEquals(8L, examen.getId());
        assertEquals("Fisica", examen.getNombre());
        verify(repository).guardar(any(Examen.class));
        verify(preguntasRepository).guardarVarias(anyList());
    }
}