public class EjemploStringTestRendimiento {
    public static void main(String[] args) {

        String a = "a";
        String b = "b";
        String c = a;

        StringBuilder stringBuilder = new StringBuilder(a);


        System.out.println("========================================================");
        long inicio = System.currentTimeMillis();


        for (int i = 0; i <500 ; i++) {
            // c = c.concat(a).concat(b).concat("\n"); //7ms
            // c += a + b + "\n"; //39MS
            stringBuilder.append(a).append(b).append("\n");  // 0. stringbuilder el mas rapido.
        }
        long fin = System.currentTimeMillis();
        System.out.println(fin - inicio);
        System.out.println("c = "+c);
        System.out.println("stringBuilder" +stringBuilder.toString());

    }
}
