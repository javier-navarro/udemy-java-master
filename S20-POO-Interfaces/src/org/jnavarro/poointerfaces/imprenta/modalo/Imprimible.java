package org.jnavarro.poointerfaces.imprenta.modalo;

public interface Imprimible {
    public String imprimir();

    default String imprimirDefault(){
        return "metodo default";
    }

    static void imprimir(Imprimible imprimible){
        System.out.println(imprimible.imprimir());
    }
}
