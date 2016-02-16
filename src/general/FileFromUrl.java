/**
 * 
 */

package general;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;


/**
 * @author ing. R.J.H.M. Stevens
 *
 */
public class FileFromUrl {
  /**
   * Downloads a file from an external server
   * @param url the url to the file
   * @param fileName The local file name
   * @return true on success else false
   */
  public static boolean download(String url, String fileName) {
    URL website;
    try {
      // source: http://stackoverflow.com/questions/921262/how-to-download-and-save-a-file-from-internet-using-java
      website = new URL(url);
      ReadableByteChannel rbc = Channels.newChannel(website.openStream());
      FileOutputStream fos = new FileOutputStream(fileName);
      fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
      fos.close();
      return true;
    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return false;
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return false;
    }
  }
}
