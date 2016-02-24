package outputGenerators;

import dataContainers.Charger;

public class XMLGenerator implements OutputInterface {
protected static String top = 
"<?xml version=\"1.0\"?> \r\n" +
"\r\n" +
"<!DOCTYPE note SYSTEM \r\n" +
"\"http://www.w3schools.com/xml/note.dtd\">\r\n" +
"\r\n"+
"<chargers>\r\n";

protected static String bottom ="</chargers>";
  @Override
  public String GeneratorOutput(Charger[] chargers) {
    String output = top;
    for(Charger charger: chargers){
      output += "\t<charger>\r\n"
          + "\t\t<id>"+ charger.getId() +"</id>\r\n"
          + "\t\t<title></title>\r\n"

          + "\t\t<coordinate>\r\n"
          + "\t\t\t<longitude>"+charger.getCoordinates().getLongitude()+"</longitude>\r\n"
          + "\t\t\t<latitude>"+charger.getCoordinates().getLongitude()+"</latitude>\r\n"
          + "\t\t</coordinate>\r\n"
          
          + "\t\t<address>\r\n"
          + "\t\t\t<zipCode></zipCode>\r\n"
          + "\t\t\t<adres></adres>\r\n"
          + "\t\t\t<city></city>\r\n"
          + "\t\t</address>\r\n"
       
          + "\t\t<info>\r\n"
          + "\t\t\t<connector>"+charger.getConnector()+"</connector>\r\n"
          + "\t\t\t<power></power>\r\n"
          + "\t\t</info>\r\n"
          
          + "\t\t<general>\r\n"
          + "\t\t\t<paid></paid>\r\n"
          + "\t\t\t<telNumber></telNumber>\r\n"
          + "\t\t\t<openingHours></openingHours>\r\n"
          + "\t\t\t<notes></notes>\r\n"
          + "\t\t\t<dateLastUpdate></dateLastUpdate>\r\n"
          + "\t\t</general>\r\n"
          
          + "\t</charger>\r\n";
      
      output += "";
    }
    output += bottom;
    return output;
  }
  


}
