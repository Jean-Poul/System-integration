package dk.jplm.si.assignment2.ipsoap;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

public class CountryFacade {
    public static String getCountryFromIp(String IP) {
        String country = "";
        try
        {
            // Given an IP-address, this code finds the country from which it is located and returns "Country code: XX, state: XX"
            GeoIPServiceLocator locator = new GeoIPServiceLocator();
            GeoIPServiceSoap_PortType service = locator.getGeoIPServiceSoap();
            String retString = service.getIpLocation(IP); // this ip is from dr.dk
            retString = retString.replace("<GeoIP><Country>", "Country code: ");
            retString = retString.replace("</Country><State>", ", state: ");
            country = retString.replace("</State></GeoIP>", "");
            // System.out.println("returned: " + country); for testing purposes
        }
        catch (ServiceException | RemoteException ex)
        {
            ex.printStackTrace();
        }

        return country;
    }
}
