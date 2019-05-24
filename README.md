# Spring Boot SOAP web services
This project demonstrates SOAP web services using Spring Boot 

## How to Run?
1. Clone the project and open in IntelliJ 
2. Run command `$ mvn compile` from root directory of the project. It will create Domain or Model classes based **book.xsd** file in resources. It will also insert sample data mentioned in **resources/data.sql** file
4. Run the project and goto URL: http://localhost:8090/ws/soap/book/book.wsdl to get WSDL for the request
5. Copy the WSDL into SOAP UI or any other SOAP testing mechanism
6. You should see following request in SOAP UI
    ```
    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gen="http://www.springdemo.com/soapws/gen">
       <soapenv:Header/>
       <soapenv:Body>
          <gen:getBookRequest>
             <gen:id><Enter Book Id Here></gen:id>
          </gen:getBookRequest>
       </soapenv:Body>
    </soapenv:Envelope>
    ```
7. Enter **2001** in `gen:id` field, and you should see following response
    ```xml
    <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
       <SOAP-ENV:Header/>
       <SOAP-ENV:Body>
          <ns2:getBookResponse xmlns:ns2="http://www.springdemo.com/soapws/gen">
             <ns2:book>
                <ns2:id>2001</ns2:id>
                <ns2:title>Java12</ns2:title>
                <ns2:numberOfPages>250</ns2:numberOfPages>
                <ns2:cost>20.99</ns2:cost>
             </ns2:book>
          </ns2:getBookResponse>
       </SOAP-ENV:Body>
    </SOAP-ENV:Envelope>
    ```
7. That's it. Your Spring SOAP webservices project up and working as expected
