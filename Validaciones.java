import java.util.*;
public class Validaciones
{
    
    //Funcion de las primeras 4 letras
    public static String acronimoNombre(Persona pers )
    {
        String acronimo = new String();
        //Verifica si los apellidos contienen Ch o Ll. Ej Chavez o Llano
        if(nombreCompuesto(pers.lastName_p.toUpperCase())==true) 
            acronimo = pers.lastName_p.substring(0,1) + pers.lastName_p.substring(2,3) + pers.lastName_m.substring(0,1) + pers.name.substring(0, 1); 
        
        //Verifica cuantas letras tiene el apellido 
        else if(letrasApellidos(pers.lastName_p) == true || letrasApellidos(pers.lastName_m) == true)
        {
            if(unApellido(pers.lastName_p.toUpperCase()) == false) //El apellido es de 2 letras o menos
                acronimo = pers.lastName_p.substring(0,1) + pers.lastName_m.substring(0,1) + pers.name.substring(0, 2);
            if(unApellido(pers.lastName_p.toUpperCase()) == true) acronimo = pers.lastName_m.substring(0,2)+pers.name.substring(0,2); //No cuenta con apellido paterno.
            else acronimo = pers.lastName_p.substring(0,2)+pers.name.substring(0,2); //No cuenta con apellido matrno
        }            
            
        //Verifica si contiene el nombre de Maria o Jose 
        else if(nombreGenericos(pers.name.toUpperCase()) == 0  )
        {  
            if(pers.name.contains("maria") == true) acronimo = pers.lastName_p.substring(0,2) + pers.lastName_m.substring(0,1) + pers.name.substring(6,7);
            else acronimo = pers.lastName_p.substring(0,2) + pers.lastName_m.substring(0,1) + pers.name.substring(5,6);
        }
        
        else if(preposiciones(pers.lastName_p.toUpperCase()) != 0 || preposiciones(pers.lastName_m.toUpperCase()) != 0 || preposiciones(pers.name.toUpperCase()) != 0 )
        {
            if(preposiciones(pers.lastName_p.toUpperCase()) != 0) acronimo = pers.lastName_p.substring( preposiciones( pers.lastName_p.toUpperCase()), preposiciones(pers.lastName_p.toUpperCase())+2 ) + pers.lastName_m.substring(0,1) + pers.name.substring(0, 1); 
            else if (preposiciones(pers.lastName_m.toUpperCase()) != 0) acronimo = pers.lastName_p.substring(0,2) + pers.lastName_m.substring(preposiciones(pers.lastName_m.toUpperCase()),preposiciones(pers.lastName_m.toUpperCase())+2) + pers.name.substring(0, 1);
            else acronimo = pers.lastName_p.substring(0,2) + pers.lastName_m.substring(0,1) + pers.name.substring(preposiciones(pers.name.toUpperCase()), preposiciones(pers.name.toUpperCase())+1 );
        }

        //Si ninguna de las anteriores se cumple /
        else acronimo = pers.lastName_p.substring(0,2) + pers.lastName_m.substring(0,1) + pers.name.substring(0, 1);

        if(palabraInapropiada(acronimo.toUpperCase()) == 0)
            acronimo = acronimo.substring(0,3) + "X" ;
        return (acronimo.toUpperCase());
    }// fin de la funcion regla1
    

    //Funcion que determina las letras del 5 al 8 (fecha de nacimiento)
    public static String acronimoFecha(Persona pers)
    {
        String fecha = new String();
        fecha = pers.dob.substring(8,10) + pers.dob.substring(3,5) + pers.dob.substring(0,2);
        return fecha;
    } //fin metodo acronimoFecha

    //Funcion que compara si los nombres son compuestos. Ej. CH y LL 
    public static boolean nombreCompuesto (String lastN)
    {
        String letras[] = {"CH", "LL"};
        String compuesta = lastN.substring(0,2);
        if((compuesta.compareTo(letras[0])==0) || (compuesta.compareTo(letras[1])==0)) return true;
        else return false;
    } //fin metodo nombreCompuesto

    public static boolean letrasApellidos(String lastN)
    {
        //String acronimo =  new String();
        if(lastN.length() <= 2) return true;
        else return false;
    } //fin metodo letrasApellidos
    
    //Metodo que busca nombres genericos Maria y Jose
    public static int nombreGenericos(String nombre)
    {
        int x = -1;
        if(nombre.contains("JOSE") == true ) x = nombre.indexOf("JOSE");
        if(nombre.contains("MARIA") == true) x = nombre.indexOf("MARIA");
        //si lo encuentra en la posicion 0, entonces se le suma 4 o 5 dependiendo si es Maria o Jose       
        return x;
    }// fin de meotodo 

    public static boolean unApellido(String lastN)
    {
        return lastN.contains("XX");
    } //fin metodo

    public static int preposiciones(String lastN)
    {
        int i = 0;
        String prepos[] = {"DE LA", "DEL", "MA.", "Y", "DE LOS"};
        while(i < prepos.length)
        {
            if(lastN.contains(prepos[i]) == true) 
                return prepos[i].length()+1;                
            i++;
        }return 0;
    } //fin metodo 

    public static int palabraInapropiada(String acronimo)
    {
        int answer = -1;
        int i = 0;
        String palabra_inconv[] = {"BUEI","BUEY","CACA","CACO","CAGA","CAGO","CAKA","CAKO",
        "COGE","COJA","COLA","COJE","COJI","COJO","CULO","FETO","GUEY","JOTO","KACA","KACO", 
        "KAGA","KAGO","KOGE","KOJO","KAKA","KULO","MAME","MAMO","MEAR","MEAS","MEON","MION",
        "MOCO", "MULA","PEDA","PEDO","PENE","PUTA","PUTO","QULO","RATA","RUIN"};
        
        while(i<palabra_inconv.length)
        {
            answer = acronimo.compareTo(palabra_inconv[i]);
            if(answer == 0) break;
            i++;
        }
        //String nuevoAcron = palabra_inconv[answer];
        return answer; //Devuelve 0 si no coincide con una palabra inconveniente
    }//fin metodo


}// fin de la clase