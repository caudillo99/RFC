public class Rfc
{
    public static char []tabla1 = {' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
    '&', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 
    'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'N'};

    public static int[] valueOfTabla1 ={00, 00, 01, 02, 03, 04, 05, 06, 07,  8,  9, 10, 
    11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25, 26, 27, 28, 29, 
    32, 33, 34, 35, 36, 37, 38, 39, 40};

    public static char []tabla2 = {'1', '2', '3', '4', '5', '6', '7', '8', '9','A', 'B', 
    'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 
    'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static int[] valueOfTabla2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 
    16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33};

    public static char []tabla3 = {'0','1', '2', '3', '4', '5', '6', '7', '8', '9','A', 'B', 
    'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', '&', 'O','P', 'Q', 'R', 'S', 
    'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', 'N'};
    
    public static int[] valueOfTabla3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 
    16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38};
    
    public static String homonimo(String name)
    {
        char[] stringToChar = name.toCharArray() ;
        String aux = "0";
        for(int i = 0; i<name.length(); i++)
        {
           for(int j = 0; j<tabla1.length; j++)
           {
               if(stringToChar[i] == tabla1[j])
               {
                    aux += valueOfTabla1[j];
                    break;
               }
           }
        }return aux;
    }//fin del metodo

    public static char claveDiferenciadora(int letra)
    {
        char aux=0;
        for(int i = 0; i<valueOfTabla2.length; i++)
        {
            if(letra == valueOfTabla2[i])
            {
                aux =  tabla2[i];
                break;
            }
        }return aux;
    }

    //Ultimo caracter del curp
    public static String ecuacionDiferenciador(String acronimo)
    {
        char[] acron = acronimo.toCharArray();
        int aux = 0;
        for(int i =0; i<acronimo.length(); i++)
        {
            for(int j = 0; j<tabla3.length; j++)
           {
               if(acron[i] == tabla3[j])
               {
                    aux += valueOfTabla3[j]*(13-i);
                    break;
               }
           }
        }
        int residuo = aux%11;
        if(residuo > 0)
            return String.valueOf(tabla3[11-residuo]);
        else if(residuo == 10)
            return "A";
        else if(residuo == 0)
            return "0";
        else return "0";

    }

}//fin clase RFC

