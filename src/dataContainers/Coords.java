package dataContainers;

import lombok.Getter;

public class Coords {
  public Coords (double longitude, double latitude){
    this.latitude = latitude;
    this.longitude = longitude;
    
  }
  @Getter private double longitude;
  @Getter private double latitude;
  
  public String toString() {
    return " lat: " + latitude + " long: " + longitude;
  }
}
