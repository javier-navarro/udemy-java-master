public class SentenciaFor {
    public static void main(String[] args) {

        for (int i = 0; i <= 5; i++) {
            System.out.println("pasando por el for.. "+ i);
        }

        for (int j = 10; j >= 0 ; j--) {
            System.out.println("pasando por el for j.. "+ j);
        }

        for (int i = 0; i <=10 ; i++) {
            if( !(i % 2 == 0)){
                continue;
            }
            System.out.println("i = " + i);
        }
    }
}
