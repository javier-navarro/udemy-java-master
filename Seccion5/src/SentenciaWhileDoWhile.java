public class SentenciaWhileDoWhile {
    //clase 61
    // el for siempre es mas rapido que el while
    public static void main(String[] args) {
        int i = 0;
        while(i < 5){
            System.out.println("i = " + i);
            i++;
        }

        i = 0;
        boolean prueba = true;
        while (prueba){
            if (i == 7){
                prueba = false;
            }
            System.out.println("i = " + i);
            i++;
        }

        //primero ejecuta y despues evalua.
        prueba = false;
        do {
            System.out.println("se ejecuto una vez");
        }while (prueba);
    }
}
