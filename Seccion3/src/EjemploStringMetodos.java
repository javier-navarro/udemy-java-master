public class EjemploStringMetodos {
    public static void main(String[] args) {
        String  nombre = "javier";
        System.out.println("nombre.length() = " + nombre.length());
        System.out.println("nombre.toUpperCase() = " + nombre.toUpperCase());
        System.out.println("nombre.toLowerCase() = " + nombre.toLowerCase());
        System.out.println("nombre.equals(\"javier\") = " + nombre.equals("javier"));
        System.out.println("nombre.equals(\"Javier\") = " + nombre.equals("Javier"));
        System.out.println("nombre.equalsIgnoreCase(\"javier\") = " + nombre.equalsIgnoreCase("javier"));

        // compareTo devuelve un int: 0 ok, otros cuando hay error
        System.out.println("nombre.compareTo(\"javier\") = " + nombre.compareTo("javier"));
        System.out.println("nombre.compareTo(\"dzeko\") = " + nombre.compareTo("dzeko"));
        System.out.println("nombre.charAt(0) = " + nombre.charAt(0));
        System.out.println("nombre.charAt(1) = " + nombre.charAt(1));
        System.out.println("nombre.charAt(nombre.length()-1) = " + nombre.charAt(nombre.length()-1));

        System.out.println("nombre.substring(1) = " + nombre.substring(1));
        System.out.println("nombre.substring(1,4) = " + nombre.substring(1,4));
        System.out.println("nombre.substring(4,6) = " + nombre.substring(4,6));
        System.out.println("nombre.substring(5) = " + nombre.substring(5));
        System.out.println("nombre.substring(nombre.length()-1)) = " + nombre.substring(nombre.length()-1));
        System.out.println("\n");
        
        String trabalenguas = "trabalenguas";
        String trabalenguasConEspacios = "  trabalenguas  ";
        System.out.println("trabalenguas = " + trabalenguas);
        System.out.println("trabalenguas.replace(\"a\",\".\") = " + trabalenguas.replace("a","."));
        // indexOf = retorna la primera posicion en la que se encuentra el caracter.
        // si retorna menor a 0 no lo encontro.
        // acepta caracteres o string
        System.out.println("trabalenguas.indexOf('a') = " + trabalenguas.indexOf('a'));
        System.out.println("trabalenguas.lastIndexOf('a') = " + trabalenguas.lastIndexOf('a'));
        //acepta solo string
        // retorna boolean
        System.out.println("trabalenguas.contains(\"t\") = " + trabalenguas.contains("z"));
        //ambos metodos reciben string, y devuelven un boolean.
        System.out.println("trabalenguas.startsWith(\"tra\") = " + trabalenguas.startsWith("tra"));
        System.out.println("trabalenguas.endsWith(\"tra\") = " + trabalenguas.endsWith("tra"));
        System.out.println("trabalenguasConEspacios.trim() = " + trabalenguasConEspacios.trim());
    }

}
