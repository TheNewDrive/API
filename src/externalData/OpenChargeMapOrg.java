package externalData;

import dataContainers.Charger;
import dataContainers.Coords;
import dataTypes.Connectors;
import general.FileFromUrl;

/**
 * @author ing. R.J.H.M. Stevens
 *
 */
public class OpenChargeMapOrg implements ExternalData {
  private String reference;
  private int refreshrate = 100;
  //private hashmap 

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
    String url = "";
    FileFromUrl.Download(url, filename);
    // TODO Auto-generated method stub
    return null;
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
    if (FileFromUrl.Download("http://api.openchargemap.io/v2/referencedata/", filename)) {
      this.reference = filename;
    }

    // TODO Auto-generated method stub
  }


}
