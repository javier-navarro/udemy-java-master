
//clase74
public class PasarPorReferencia {
    public static void main(String[] args) {
        int edad[] = {10,11,12};

        System.out.println("iniciamos main ");
        for (int i = 0; i < edad.length; i++) {
            System.out.println("edad[i] = " + edad[i]);
        }
        System.out.println("Antes de llamar al metodo test");
        test(edad);
        System.out.println("Despues de llamar al metodo test");

        for (int i = 0; i < edad.length; i++) {
            System.out.println("edad[i] = " + edad[i]);
        }
        System.out.println("Finalizamos main con datos modificados");
    }

    public static void test(int[] array){
        System.out.println("Iniciando metodo test ");
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] + 20;
        }
        System.out.println("Finaliza metodo test ");

    }
}
