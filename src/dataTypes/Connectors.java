/**
 * 
 */
package dataTypes;

/**
 * @author ing. R.J.H.M. Stevens
 *
 */
public enum Connectors {
	unknown(0), shucko(1);
	
	private final int type;
	Connectors(int type){ this.type = type; }
	
	public int getType() { return this.type; } 
}
