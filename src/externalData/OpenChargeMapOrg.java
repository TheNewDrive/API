package externalData;

import dataContainers.Charger;
import dataContainers.Coords;
import dataTypes.Connectors;
import general.FileFromUrl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;




/**
 * @author ing. R.J.H.M. Stevens
 *
 */
public class OpenChargeMapOrg implements ExternalData {
  private String reference;

  /**
   * Creates the class and updates the references
   * if the reference cant be updated it kills the program
   */
  public OpenChargeMapOrg() {
    updateReferenceData();
    if (reference == null) {
      System.exit(100);
    }
  }
  
  @Override
  public Charger[] getChargePoints(Coords coordinates) {
    long time = System.currentTimeMillis() / 1000L;
    String filename = "openchargemap" + time + ".json";
    String url = "http://api.openchargemap.io/v2/poi/?output=json&countrycode=BE&latitude="+coordinates.getLatitude()+"&longitude="+coordinates.getLongitude()+"&distance=50&distanceunit=KM";
    if (!FileFromUrl.download(url, filename)) {
      return null;
    }
    
    return ProccessFile(filename);
  }

  @Override
  public Charger[] getChargePoints(Coords coordinates, Connectors[] connector) {
    // TODO Auto-generated method stub
    return null;  
  }

  @Override
  public Charger[] getChargePoints(Coords coordinates, Connectors[] connector,
      int[] company, int distence) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void updateReferenceData() {
    long time = System.currentTimeMillis() / 1000L;
    String filename = "opencharemapRef" + time + ".json";
    if (FileFromUrl.download("http://api.openchargemap.io/v2/referencedata/", filename)) {
      this.reference = filename;
    }
  }
  
  private Charger[] ProccessFile(String name){
    String line = "";
    
    InputStream input;
    try {
      input = new FileInputStream(name);
    } catch (FileNotFoundException e) {
      return null;
    }
    InputStreamReader reader = new InputStreamReader(input);
    BufferedReader buffer = new BufferedReader(reader);
    List<Charger> chargers = new ArrayList<Charger>();
    Charger tempCharger = null;
    try {
      while((line = buffer.readLine()) != null){
        String temp = line.replaceAll(" ", "");
        
        /*
         * look for a line that only contains a opening tag
         * if the next line hold an id its the id of a new charger
         */
        if (temp.equals("{") && (line = buffer.readLine()) != null){
          if (line.contains("\"ID\":")){
            tempCharger = new Charger();
            chargers.add(tempCharger);
            tempCharger.setCoordinates(new Coords());
            line = line.replaceAll("\"ID\":", "");        /* remove the id tag */
            line = line.replaceAll(",", "");              /* remove the comma tag */
            line = line.replaceAll(" ", "");              /* remove the space tag */
            tempCharger.setId(Integer.parseInt(line));
          }
        }
        else if(line == null){
          break;
        }
        else if(line.contains("\"Latitude\":")){
          tempCharger.getCoordinates().setLatitude(0.0);
          if (!line.contains("null")){
            line = line.replaceAll("\"Latitude\":", "");    /* remove the Latitude tag */
            line = line.replaceAll(",", "");                /* remove the comma tag */
            line = line.replaceAll(" ", "");                /* remove the space tag */
            tempCharger.getCoordinates().setLatitude(Double.parseDouble(line));
          }
          
        } 
        else if(line.contains("\"Longitude\":")){
          tempCharger.getCoordinates().setLongitude(0.0);
          if (!line.contains("null")){
            line = line.replaceAll("\"Longitude\":", "");   /* remove the Longitude tag */
            line = line.replaceAll(",", "");                /* remove the comma tag */
            line = line.replaceAll(" ", "");                /* remove the space tag */
            tempCharger.getCoordinates().setLongitude(Double.parseDouble(line));
          }
        }
        else if(line.contains("\"UserComments\": [") || line.contains("\"Connections\": [") || line.contains("\"MediaItems\": [")){
          while (!line.contains("]") && line != null){
            line = buffer.readLine();
          }
        }
        
      }
    } catch (IOException e) {
      return null;
    }
    try {
      buffer.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return chargers.toArray(new Charger[chargers.size()]);
  }


}
