package org.jnavarro.tarea28.runnable;

public class AlfanumericoTarea implements Runnable{
    public enum Tipo {
        NUMERO(),
        LETRA();
        private String[] letras = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O",
                "P","Q","R","S","T","U","V","W","X","Y","Z"};
        private int[] numeros = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        public String[] getLetras() {
            return letras;
        }

        public int[] getNumeros() {
            return numeros;
        }
    };
    private Tipo tipo;

    public AlfanumericoTarea(Tipo tipo) {
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    @Override
    public void run() {
        System.out.println("tipo: " + tipo.name());

        if(tipo.name().equalsIgnoreCase("LETRA")) {
            System.out.println("===============IMPRIMIENDO LETRAS======================");
            for (int i = 0; i <tipo.letras.length; i++) {
                System.out.println((i+1)+ " - "+tipo.letras[i]);
            }
        }else if(tipo.name().equalsIgnoreCase("NUMERO")){
            System.out.println("===============IMPRIMIENDO NUMEROS======================");
            for (int j = 0; j <tipo.numeros.length; j++) {
                System.out.println((j+1)+ " - "+tipo.numeros[j]);
            }
        }



    }
}
