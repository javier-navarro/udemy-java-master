package org.jnavarro.patrones.decorator.decorador;

import org.jnavarro.patrones.decorator.Formateable;

abstract public class TextoDecorador implements Formateable {
    protected Formateable texto;

    public TextoDecorador(Formateable texto) {
        this.texto = texto;
    }


}
