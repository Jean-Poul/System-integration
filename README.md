## System Integration 2022 Assignment 2: Mini Project 1: WS and SOA  
  
#### Write how it works and our thougths


The purpose with this assignement is to send e-mails to the group of Company Stakeholders invited to the event.
Service uses a soap api on http://wsgeoip.lavasoft.com/ipservice.asmx?wsdl in order to determinate country code based on IP address of the reciepients.
Then it calls a rest api on https://api.genderize.io providing firstname and country code "https://api.genderize.io?name=myfirstname&country_id=DK" in order to determinate gender of the recipients.

Emails are sent with free SMTP service : https://www.wpoven.com/tools/free-smtp-server-for-testing . To view sent emails use: use email magdalena@cphbusiness.dk

In order to connect to SMTP service it might be necessery to disable your FireWall!

Endpoint address is POST http://localhost:8099/emails and you can test it with Postman by providing Body type form-data with two fields: 
"file" which must be of type file - choose file from your local machine
"list" which must be of type text and it can be found here https://github.com/Jean-Poul/System-integration-assignment-2/blob/main/docs/listValue.txt

