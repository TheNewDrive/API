/**
 * 
 */
package dataContainers;
import dataTypes.*;

/**
 * @author ing. R.J.H.M. Stevens
 *
 */
public class Charger {
	private int id;
	private float longitude;
	private float latitude;
	private Connectors connector = Connectors.unknown;
	private Status status = Status.unknown; 
	private String notes;
	private int companyId;
}
