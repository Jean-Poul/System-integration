package dk.si.ipsoap;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

@SpringBootApplication
public class IpSoapApplication {

    public static void main(String[] args)
    {
        String country = CountryFacade.getCountryFromIp("23.73.130.158");
        System.out.println(country);
    }

}
