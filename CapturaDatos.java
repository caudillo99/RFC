import java.util.Scanner;

public class CapturaDatos
{
    public static String capturaInfo(String msg)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("" + msg + ": " ); 
        return sc.nextLine();
    }

    public static String capturaFechaNacimiento(String msg)
    {
        Scanner sc = new Scanner(System.in);
        /* Variables tipo String para capturar fecha */
        String day = new String();
        String month = new String();
        String year = new String();
        /* Captura de la fecha */
        System.out.println(msg + "Ej. dd/mm/aaaa");
        System.out.print("Dia: ");  day = sc.nextLine();
        System.out.print("Mes: ");  month = sc.nextLine();
        System.out.print("Anio: "); year = sc.nextLine();
        /* Regresa cadena con el formato dd/mm/aaaa */
        return String.join("/", day, month, year);
    }// Fin del metodo de capturar fecha

}// Fin de la clase CapturaDatos