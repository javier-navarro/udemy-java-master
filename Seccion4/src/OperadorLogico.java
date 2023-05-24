public class OperadorLogico {

    public static void main(String[] args) {
        //siempre se evaluan de izquierda a derecha
        // en java tiene prioridad el and por sobre el or.
        System.out.println("========================================================");

        int i = 3;
        byte j = 3;
        float k = 127e-7f;
        double l = 2.1413e3;
        boolean m = false;
        
        // para que sea true, todas las condiciones deben ser true, 1 en falso y el valor sera falso
        boolean comparador1 = i ==j && k < l;
        System.out.println("comparador1 = " + comparador1);
        
        //
        boolean comparador2 = i == j || k > l;
        System.out.println("comparador2 = " + comparador2);
        
        //el poner parentesis en las comparaciones, les da prioridad y pueden cambiar por completo el resultado
        boolean comparador3 = i == j && (k > l || m == false);
        System.out.println("comparador3 = " + comparador3);
        
        boolean comparador4 = i == j || (k < l && m ==true);
        System.out.println("comparador4 = " + comparador4);
        
        boolean comparador5 = (true || true) && false;
        System.out.println("comparador5 = " + comparador5);
        
        boolean comparador6 = true || (false && false) || false;
        System.out.println("comparador6 = " + comparador6);
    }
}
