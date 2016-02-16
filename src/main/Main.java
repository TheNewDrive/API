package main;

import dataContainers.Charger;
import dataContainers.Coords;
import externalData.ExternalData;
import externalData.OpenChargeMapOrg;

/**
 * @author ing. R.J.H.M. Stevens
 *
 */
public class Main {

  /**
   * This is the main method this function makes all calls to start the program
   * @param args the arguments that the user gives
   */
  public static void main(String[] args) {
    
    ExternalData data = new OpenChargeMapOrg();
    Coords coords = new Coords (5.7927004, 50.7785433);
    Charger[] chargers = data.getChargePoints(coords);
    for(Charger charger: chargers){
      System.out.println(charger.toString());
    }
    // TODO Auto-generated method stub

  }

}
