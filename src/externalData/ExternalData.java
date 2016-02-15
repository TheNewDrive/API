package externalData;

import dataContainers.Charger;
import dataContainers.Coords;
import dataTypes.Connectors;

public interface ExternalData {

  Charger[] getChargePoints(Coords coordinates);
  
  Charger[] getChargePoints(Coords coordinates, Connectors[] connector);
  
  Charger[] getChargePoints(Coords coordinates, Connectors[] connector, 
      int[] company, int distence);
  
  void updateReferenceData();
}
