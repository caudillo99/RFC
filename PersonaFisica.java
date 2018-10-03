import java.util.*;

import javax.swing.JOptionPane;
public class PersonaFisica
{
    public static void main(String[] args) 
    {
        //String prueba = new String();
        System.out.println("En caso de NO contar un apellido escribir 'xx' ");
        Persona pers1 = new Persona(CapturaDatos.capturaInfo("Nombre"), CapturaDatos.capturaInfo("Apellido Paterno"), CapturaDatos.capturaInfo("Apellido materno"), CapturaDatos.capturaFechaNacimiento("Fecha de nacimiento "));        
        System.out.print("\n\n\n");
        String rfc = new String(Validaciones.acronimoNombre(pers1)+Validaciones.acronimoFecha(pers1)+ "-"+pers1.homoClave());
        System.out.println("RFC: "+ rfc +Rfc.ecuacionDiferenciador(rfc)); 
        JOptionPane.showMessageDialog(null, rfc+Rfc.ecuacionDiferenciador(rfc));
    }//Fin de main

}//Fin de clase persona fisica