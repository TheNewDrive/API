/**
 * https://projectlombok.org/features/GetterSetter.html
 */

package dataContainers;

import java.util.Date;
import dataTypes.Connectors;
import dataTypes.Status;
import lombok.Getter;

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
  @Getter private int id;
  @Getter private Coords coordinates;
  @Getter private Connectors connector = Connectors.unknown;
  @Getter private Status status = Status.unknown; 
  @Getter private String notes;
  @Getter private int companyId;

  @Getter private Date updated;
  @Getter private Date vallid;
}
