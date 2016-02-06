/**
 * https://projectlombok.org/features/GetterSetter.html
 */
package dataContainers;
import dataTypes.*;

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
	
	/**
	 * 
	 */
	@Getter private float longitude;
	@Getter private float latitude;
	@Getter private Connectors connector = Connectors.unknown;
	@Getter private Status status = Status.unknown; 
	@Getter private String notes;
	@Getter private int companyId;
}
