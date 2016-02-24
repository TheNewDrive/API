/**
 * https://projectlombok.org/features/GetterSetter.html
 */

package dataContainers;

import java.util.Date;
import dataTypes.Connectors;
import dataTypes.Status;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ing. R.J.H.M. Stevens
 * @date 6-feb-2016
 *
 */ 
public class Charger {

  /**
   * The id of the charger
   * @param returns the internal charger id
   */
  @Setter @Getter private int id;
  @Setter @Getter private Coords coordinates;
  @Setter @Getter private Connectors connector = Connectors.unknown;
  @Setter @Getter private Status status = Status.unknown; 
  @Setter @Getter private String notes;
  @Setter @Getter private int companyId;

  @Setter @Getter private Date updated;
  @Setter @Getter private Date vallid;
  
  public String toString() {

    return "id: " + id + " Coords: " + coordinates.toString();
  }
  
}
