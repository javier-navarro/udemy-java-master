package org.jnavarro.tarea28;

import org.jnavarro.tarea28.runnable.AlfanumericoTarea;

public class MainTarea28 {
    public static void main(String[] args) {
        new Thread(new AlfanumericoTarea(AlfanumericoTarea.Tipo.NUMERO)).start();
        new Thread(new AlfanumericoTarea(AlfanumericoTarea.Tipo.LETRA)).start();
    }
}
