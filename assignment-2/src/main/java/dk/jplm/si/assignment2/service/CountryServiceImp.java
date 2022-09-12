package dk.jplm.si.assignment2.service;

import dk.jplm.si.assignment2.ipsoap.GeoIPServiceLocator;
import dk.jplm.si.assignment2.ipsoap.GeoIPServiceSoap_PortType;
import org.springframework.stereotype.Service;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

@Service
public class CountryServiceImp implements CountryService {
    @Override
    public String getCountryByIP(String IP) throws Exception {
        String country = "";
        try {
            GeoIPServiceLocator locator = new GeoIPServiceLocator();
            GeoIPServiceSoap_PortType service = locator.getGeoIPServiceSoap();
            String retString = service.getIpLocation(IP);
            System.out.println(country);
        } catch (ServiceException | RemoteException ex) {
            ex.printStackTrace();
        }
        return country;
    }
}
