import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import java.util.Random;

@WebService(name = "Service", targetNamespace = "utez")
@SOAPBinding(style = SOAPBinding.Style.RPC)

public class Service {
    @WebMethod(operationName = "responseMessage")
    public String responseMessage(@WebParam(name = "message") String message){
        return "El mensaje recibido fue "+ message;
    }

    @WebMethod(operationName = "numeroAleatorio")
    public String numeroAleatorio(@WebParam(name = "numero") int mesaje){
        int numAlea = (int) (Math.random()*4+1);
        if(mesaje == numAlea){
            return "Ganaste Invocador";
        }else{
            return "Perdiste";
        }
    }

    @WebMethod(operationName = "cosonantes")
    public String cosonantes(@WebParam(name="palabra") String mensaj){
        mensaj =mensaj.toLowerCase();
        mensaj = mensaj.replace("a", "");
        mensaj = mensaj.replace("e","");
        mensaj = mensaj.replace("i","");
        mensaj = mensaj.replace("o","");
        mensaj = mensaj.replace("u","");
        return mensaj;
    }

    @WebMethod(operationName = "rfc")
    public String rfc(@WebParam(name="datas") String nombre, String paterno, String materno, String fecha){

        String homoclave="";
        String alpha = "abcdefghijklmnopqrstuvwyxz";
        Random random = new Random();
        homoclave = alpha.charAt(random.nextInt(alpha.length()-1))+"";
        int n1 = (int) (Math.random()*10+1);
        int n2 = (int) (Math.random()*10+1);

        homoclave += String.valueOf(n1);

        homoclave += String.valueOf(n2);

        String crearRfc = "";
        crearRfc += paterno.charAt(0);
        crearRfc += paterno.charAt(1);
        crearRfc += materno.charAt(0);
        crearRfc += nombre.charAt(0);
        crearRfc += fecha.charAt(8);
        crearRfc += fecha.charAt(9);
        crearRfc += fecha.charAt(3);
        crearRfc += fecha.charAt(4);
        crearRfc += fecha.charAt(0);
        crearRfc += fecha.charAt(1);
        crearRfc += homoclave;

        return crearRfc;
    }


    public static void main(String[] args){
        System.out.println("Intializing server...");
        Endpoint.publish("http://localhost:8081/Service", new Service());
        System.out.println("Watting requeste...");
    }

}

