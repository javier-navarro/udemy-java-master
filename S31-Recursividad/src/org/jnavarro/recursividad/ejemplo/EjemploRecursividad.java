package org.jnavarro.recursividad.ejemplo;

import org.jnavarro.recursividad.ejemplo.models.Componente;

import java.util.stream.Stream;

public class EjemploRecursividad {
    public static void main(String[] args) {
        Componente pc = new Componente("Gabinete pc");
        Componente poder = new Componente("Fuente de poder");
        Componente placaMadre = new Componente("Placa madre");
        Componente cpu = new Componente("CPU Ryzen");
        Componente ventilador = new Componente("ventilador cpu");
        Componente disipador = new Componente("disipador cpu");
        Componente gpu = new Componente("Nvidia gpu");
        Componente tarjetaVideo = new Componente("tarjetaVideo");
        Componente gpuRam = new Componente("4GB RAM");
        Componente gpuRam2 = new Componente("4GB RAM");
        Componente gpuVentiladores = new Componente("gpuVentiladores");
        Componente ram = new Componente("Ram 32GB");
        Componente ssd = new Componente("Disco SSD 2T");

        cpu.addComponente(ventilador)
                .addComponente(disipador);

        tarjetaVideo.addComponente(gpu)
                .addComponente(gpuRam)
                .addComponente(gpuRam2)
                .addComponente(gpuVentiladores);
        placaMadre.addComponente(cpu)
                .addComponente(tarjetaVideo)
                .addComponente(ram)
                .addComponente(ssd);

        pc.addComponente(poder)
                .addComponente(placaMadre)
                .addComponente(new Componente("Teclado"))
                .addComponente(new Componente("mouse"));

        metodoRecursivoJava8(pc,0).forEach(c-> System.out.println("\t".repeat(c.getNivel()) + c.getNombre()));

    }

    public static void metodoRecursivo(Componente componente, int nivel){
        System.out.println("\t".repeat(nivel) + componente.getNombre());
        if(componente.tieneHijos()){
            for (Componente hijo: componente.getHijos()){
                metodoRecursivo(hijo, nivel+1);
            }
        }
    }

    public static Stream<Componente> metodoRecursivoJava8(Componente componente, int nivel){
        componente.setNivel(nivel);
        return Stream.concat(Stream.of(componente),
                componente.getHijos().stream()
                        .flatMap(hijo ->metodoRecursivoJava8(hijo,nivel+1)));
    }
}
