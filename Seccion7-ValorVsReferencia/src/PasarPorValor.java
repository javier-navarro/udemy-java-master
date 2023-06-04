
//clase73
public class PasarPorValor {
    public static void main(String[] args) {
        int i = 10;

        System.out.println("iniciamos con valor de i = " + i);
        test(i);
        System.out.println("Finalizamos  con valor de i = " + i);
    }

    public static void test(int i){
        System.out.println("Iniciando metodo test con i ="+ i);
        i = 35;
        System.out.println("Finaliza metodo test con i ="+ i);

    }
}
