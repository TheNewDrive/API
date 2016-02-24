package dataContainers;

import lombok.Getter;
import lombok.Setter;

public class Coords {
  public Coords(){}
  public Coords (double longitude, double latitude){
    this.latitude = latitude;
    this.longitude = longitude;
    
  }
  @Setter @Getter private double longitude;
  @Setter @Getter private double latitude;
  
  public String toString() {
    return " lat: " + latitude + " long: " + longitude;
  }
}
