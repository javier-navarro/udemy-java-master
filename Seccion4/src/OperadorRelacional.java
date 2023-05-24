public class OperadorRelacional {
    public static void main(String[] args) {
        System.out.println("========================================================");

        int i = 3;
        byte j = 7;
        float k = 127e-7f;
        double l = 2.1413e3;
        boolean m = false;

        //comparacion de igualdad
        boolean comparador = i == j;
        System.out.println("comparador = " + comparador);
        
        boolean comparador2 = !comparador;
        System.out.println("comparador2 = " + comparador2);

        boolean comparador3 = i !=j;
        System.out.println("comparador3 = " + comparador3);

        boolean comparador4 = m == true;
        System.out.println("comparador4 = " + comparador4);

        boolean comparador5 = m != true;
        System.out.println("comparador5 = " + comparador5);

        boolean comparador6 = i > j;
        System.out.println("comparador6 = " + comparador6);

        boolean comparador7 = j < i;
        System.out.println("comparador7 = " + comparador7);

        boolean comparador8 = l >= k;
        System.out.println("comparador8 = " + comparador8);
        
        boolean comparador9 = l <= k;
        System.out.println("comparador9 = " + comparador9);
        
        
    }
}
