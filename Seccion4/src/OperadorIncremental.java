public class OperadorIncremental {
    public static void main(String[] args) {

        //pre-incremento
        int i = 1;
        int j = ++i;

        System.out.println("========================================================");
        System.out.println("i = " + i);
        System.out.println("j = " + j);

        //post-incremento
        //primero se asigna despues se incrementa
        i = 2;
        System.out.println("valor inicial de i = " + i);
        j = i++;

        System.out.println("i = " + i);
        System.out.println("j = " + j);

        //pre-decremento
        i = 3;
        j = --i;

        System.out.println("\n");
        System.out.println("i = " + i);
        System.out.println("j = " + j);

        //post-decremento
        i = 4;
        j = i--;

        System.out.println("i = " + i);
        System.out.println("j = " + j);

        System.out.println("(++j) = " + (++j));
        System.out.println("(j++) = " + (j++));
        System.out.println("j = " + j);
    }
}
