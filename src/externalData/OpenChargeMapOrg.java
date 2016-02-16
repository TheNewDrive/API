package externalData;

import dataContainers.Charger;
import dataContainers.Coords;
import dataTypes.Connectors;
import general.FileFromUrl;
import org.json.*;

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
    
    // TODO Auto-generated method stub
  }
  
  private Charger[] ProccessFile(String name){
    return null;
    
  }


}
