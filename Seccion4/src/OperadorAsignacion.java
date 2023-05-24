public class OperadorAsignacion {
    public static void main(String[] args) {
        int i = 5;
        int j = i +4;
        System.out.println("i = " + i);
        i = i + 2; // es lo mismo que i+=2


        System.out.println("========================================================");
        System.out.println("i = " + i);
        System.out.println("j = " + j);

        i += 5;
        System.out.println("i = " + i);
        
        j -= 4;
        System.out.println("j = " + j);
        
        j *= 3;
        System.out.println("j = " + j);

        String sqlString = "select * from clientes as c";
        sqlString += " where c=nombre='Javier'";
        sqlString += " and c.activo = 1";

        System.out.println("\n");
        System.out.println("sqlString = " + sqlString);
    }
}
