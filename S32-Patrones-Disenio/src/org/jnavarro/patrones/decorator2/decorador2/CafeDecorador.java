package org.jnavarro.patrones.decorator2.decorador2;

import org.jnavarro.patrones.decorator2.Configurable;

abstract public class CafeDecorador implements Configurable {
    protected  Configurable cafe;

    public CafeDecorador(Configurable cafe) {
        this.cafe = cafe;
    }
}
