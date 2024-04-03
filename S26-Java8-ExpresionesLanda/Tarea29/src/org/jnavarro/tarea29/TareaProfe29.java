package org.jnavarro.tarea29;

public class TareaProfe29 {

    public static void main(String[] args) {

        FormatearFrase format = frase -> {
            return frase.replace(".", "")
                    .replace(",", "").replace(" ", "")
                    .toUpperCase();
        };

        String resultado = format.limpiarYformatear("Pedro Pablo Pérez Pereira, pobre pintor portugués, pinta paisajes por poca plata, para pasear por París.");
        System.out.println(resultado);
    }
}
