package Seccion14_POO_ClasesObjetos;

//opcion 1
/*
public enum Color {
    ROJO,
    AMARILLO,
    AZUL,
    BLANCO,
    GRIS,
    NARANJO,
    VERDE;
}

 */

public enum Color {
    ROJO("Rojo"),
    AMARILLO("Amarillo"),
    AZUL("Azul"),
    BLANCO("Blanco"),
    GRIS("Gris"),
    NARANJO("Naranjo"),
    VERDE("Verde");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor(){
      return color;
    };

    @Override
    public String toString() {
        return this.color;
    }
}



