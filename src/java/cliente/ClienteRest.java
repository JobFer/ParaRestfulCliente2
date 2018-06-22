package cliente;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.util.List;

public class ClienteRest {

    public static void main(String[] args) {
        
        ClienteRest c = new ClienteRest();
        c.insertar();
//        c.eliminar(61);
//        c.modificar();
        System.out.println(c.listarTodos());

    }

    public void insertar(){
        String urlRestService = "http://localhost:8010/ParaRestful2/webresources/com.modelo.producto/";
        //Lo anterior si, pero por POST
        System.out.println("######## Invoke Rest Service: [" + urlRestService + "]");

        Producto vo = new Producto();
        vo.setCodigo(10);
        vo.setNombre("Manzana");
        vo.setPrecio(23);

        ClientConfig clientConfig = new DefaultClientConfig();
        Client client = Client.create(clientConfig);
        WebResource webResource = client.resource(urlRestService);

        ClientResponse response = webResource.post(ClientResponse.class, vo);
        
//      //Si queremos enviar el parametro en JSON:
//        String voo = "{\n"
//                + " \"id\" : \"2\",\n"
//                + " \"nombre\" : \"pepe\",\n"
//                + " \"primerapellido\" : \"perez\",\n"
//                + " \"segundoapellido\" : \"perez\",\n"
//                + " \"email\":\"bb@bb.bb\"\n"
//                + "}";
//        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, voo);
    }
    
    public void eliminar(int reg){
        String urlRestService = "http://localhost:8010/ParaRestful2/webresources/com.modelo.producto/"+reg;
        //Lo anterior si, pero por DELETE
        System.out.println("######## Invoke Rest Service: [" + urlRestService + "]");

        ClientConfig clientConfig = new DefaultClientConfig();
        Client client = Client.create(clientConfig);
        WebResource webResource = client.resource(urlRestService);

        //La llamada al WS REST
        ClientResponse response = webResource.delete(ClientResponse.class);
    }    
    
    public void modificar(){
        String urlRestService = "http://localhost:8010/ParaRestful2/webresources/com.modelo.producto/2";
        //Lo anterior si, pero por PUT
        System.out.println("######## Invoke Rest Service: [" + urlRestService + "]");

        Producto vo = new Producto();
        vo.setCodigo(61);
        vo.setNombre("Manzana");
        vo.setPrecio(24);

        ClientConfig clientConfig = new DefaultClientConfig();
        Client client = Client.create(clientConfig);
        WebResource webResource = client.resource(urlRestService);

        //La llamada al WS REST
        ClientResponse response = webResource.put(ClientResponse.class, vo);
    }
    
    public List<Producto> listarTodos(){
        String urlRestService = "http://localhost:8010/ParaRestful2/webresources/com.modelo.producto";
        
        //Lo anterior si, pero por GET
        System.out.println("######## Invoke Rest Service: [" + urlRestService + "]");

        ClientConfig clientConfig = new DefaultClientConfig();
        Client client = Client.create(clientConfig);
        WebResource webResource = client.resource(urlRestService);

        //La llamada al WS REST
        List<Producto> lista = webResource.get(new GenericType<List<Producto>>(){});
        
//      //Si queremos la respuesta en JSON:
//        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
//        System.out.println("response: " + response.getEntity(String.class) + "\n");
        
        return lista;
    }    
}
