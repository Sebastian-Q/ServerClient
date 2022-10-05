import utez.Service;
import utez.ServiceService;

import java.util.Scanner;

public class SoapClient {

    public static void main(String[] args){
        ServiceService service = new ServiceService();
        Service port = service.getServicePort();
        String response = port.responseMessage("Sebastian");
        System.out.println(response);
        Scanner leer = new Scanner(System.in);
        int opc = 0;
        do {
            System.out.println("Elegir una opcion \n1.-Numero Aleatorito \n2.-Cosonante \n3.-Ejercicio 3");
            opc = leer.nextInt();
            switch (opc){
                case 1:
                    int validar = 0;
                    do{
                        System.out.println("Ingresar un numero: ");
                        int numero = leer.nextInt();
                        String respuesta = (port.numeroAleatorio(String.valueOf(numero)));
                        if (respuesta.equals("Perdiste")){
                            System.out.println("Numero Incorrecto");
                            validar = 1;
                        }else {
                            System.out.println("Numero Correcto");
                            System.out.println(respuesta);
                            validar=0;
                        }
                    }while (validar!=0);
                    break;
                case 2:
                    System.out.println("Introducir una palabra");
                    String palabra = leer.next();
                    String resp = port.cosonantes(palabra);
                    System.out.println("Palabra sin cosonantes: "+resp);
                    break;
                case 3:
                    System.out.println("Introdocir nombre:");
                    String nombre = leer.next();
                    System.out.println("Introducir Apxellido Paterno");
                    String paterno = leer.next();
                    System.out.println("Introducir Apellido Materno:");
                    String materno = leer.next();
                    System.out.println("Introducir Fecha de Nacimiento: (03/07/2002 dd/mm/año)");
                    String fechaN = leer.next();
                    String re = port.rfc(nombre,paterno,materno, fechaN);
                    System.out.println(re.toUpperCase());
                    break;
                default:
                    System.out.println("No selecciono ninguna");
            }
        }while (opc !=3);




    }
}
