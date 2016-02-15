package dataTypes;

/**
 * @author ing. R.J.H.M. Stevens
 *
 */
public enum Status {
  free(1), inUse(2), broken(3), unknown(0);

  private final int status;
  Status(int status) {
    this.status = status;
  }

  public int getStatus() {
    return this.status;
  }
}
