# System Integration 2022 Assignment 2: Mini Project 1: WS and SOA  

## Group Members  
  
- Frederik Johnsen, cph-fj111@cphbusiness.dk    
- Jean-Poul Leth-Møller, cph-jl360@cphbusiness.dk     
- Mathias Parking, cph-mp525@cphbusiness.dk  
- Magdalena Wawrzak cph-mw216@cphbusiness.dk
  

### Brief introduction: 
  
This assignment is about creating a service which acts as a client to be able to communicate with other web services in the form of SOAP and REST services.


#### Application overview:  
  
The main purpose of this application is to be able to automize e-mails creation and sending these e-mails to the group of company stakeholders invited to a sepecific event.
To be able to generate this specific e-mail our service uses a SOAP API (http://wsgeoip.lavasoft.com/ipservice.asmx?wsdl). This web service is called in order to determinate country code based on IP address of the recipients.  
Furthermore in order to determinate gender of recipients a REST API (https://api.genderize.io) is used where our service will provide firstname and country code.  

Example:  
```shell
"https://api.genderize.io?name=Dennis&country_id=DK"   
```
  
When this is accomplished e-mails will be sent with the use of a free SMTP service (https://www.wpoven.com/tools/free-smtp-server-for-testing). To view the sent emails from the SMTP service use the following e-mail: magdalena@cphbusiness.dk  

FYI:  
In order to connect to the SMTP service it might be necessery to disable your firewall.

#### How to test the application:  

Use software like Postman.
  
Make a POST request to our endpoint http://localhost:8099/emails by providing body type -> form-data with two key fields:   
"file" which must be of type file - choose file from your local machine.  
"list" which must be of type text and it can be found here https://github.com/Jean-Poul/System-integration-assignment-2/blob/main/docs/listValue.txt  
