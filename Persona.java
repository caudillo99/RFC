public class Persona
{
    //Atributos de una persona
    String name;
    String lastName_p;
    String lastName_m;
    String dob;
    //String gender; Gender no es necesario para determinar el rfc de una persona

    //Constructor de la clase persona
    public Persona(String name, String lastName_p, String lastName_m, String dob)
    {
        setName(name);
        setLastNameP(lastName_p);
        setLastNameM(lastName_m);
        setFechaNacimiento(dob);
    }

    //setters & getters
    public void setName(String name) {this.name = name;}

    public void setLastNameP(String lastName_p) {this.lastName_p = lastName_p;}

    public void setLastNameM(String lastName_m) {this.lastName_m = lastName_m;}

    public void setFechaNacimiento(String dob) {this.dob = dob;}
    

    //metodo para determinar homoclave
    public String homoClave()
    {
        String fullName = lastName_p +" "+ lastName_m +" "+ name;  //nombre completo de la persona
        String homo =  Rfc.homonimo(fullName.toUpperCase()); // Regresa el valor del nombre con formato de los numeros de la tabla proporcionados 
        String num = ecuacionHomonimo(homo); // Se assigna el resultado de la ecuacion en formato cadena
        int aux = Integer.parseInt(num.substring(1));// Se extraen solo los ultimos 3 datos del resultado de la operacion 
        String result = String.valueOf(Rfc.claveDiferenciadora(aux/34)) + String.valueOf(Rfc.claveDiferenciadora(aux%34)); //Cadena con el resultado del cociente y diviendo de la operacion
        return result;    
    }// fin del metodo homoclave

    //Metodo para la ecuacion de la homoclave
    private String ecuacionHomonimo(String homo)
    {
        int  aux = 0;
        for(int i=0; i<homo.length()-1; i++)
            // va realizando la suma de la ecuacion. Ejemplo: 17*7 + 78*8 + 83*3 + ......
            aux +=  (Integer.parseInt(homo.substring(i,i+1))*10 + Integer.parseInt(homo.substring(i+1,i+2))) * Integer.parseInt(homo.substring(i+1,i+2)) ;
        return Integer.toString(aux);
    }


}// fin de la clase Persona