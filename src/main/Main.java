package main;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Map;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import dataContainers.Charger;
import dataContainers.Coords;
import externalData.ExternalData;
import externalData.OpenChargeMapOrg;
import httpParamFilters.ParameterFilter;
import outputGenerators.XMLGenerator;

/**
 * @author ing. R.J.H.M. Stevens
 *
 */
public class Main {
  
  
  public static void main(String[] args) throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
    HttpContext context = server.createContext("/v1", new MyHandler());
    context.getFilters().add(new ParameterFilter());
    server.setExecutor(null); // creates a default executor
    server.start();
}

static class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
      Map<String, String> params = (Map<String, String>)exchange.getAttribute("parameters");
        String response = "wrong url params";
        if (params.containsKey("long") && params.containsKey("lat")){
          
          Coords coords = new Coords (Double.parseDouble(params.get("long")), Double.parseDouble(params.get("lat")));
          ExternalData data = new OpenChargeMapOrg();
          Charger[] chargers = data.getChargePoints(coords);
          
          response = (new XMLGenerator()).GeneratorOutput(chargers);
        }
        
        
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}

  /**
   * This is the main method this function makes all calls to start the program
   * @param args the arguments that the user gives
   */
 // public static void main(String[] args) {
    
//    ExternalData data = new OpenChargeMapOrg();
 //   Coords coords = new Coords (5.7927004, 50.7785433);
 //   Charger[] chargers = data.getChargePoints(coords);
  //  for(Charger charger: chargers){
   //   System.out.println(charger.toString());
  //  }
    // TODO Auto-generated method stub

  //}

}
