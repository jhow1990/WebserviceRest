WebServiceRest
=======================

What is it?
-------------
This is a webservice that will calculate the distance between cities and the return units
the result in KM or MI as the user sends via parameter, in addition to displaying
like information in an XML or jason file.



How to use
-----------------------

You should have a tomcat web server version 8 or higher

Deploy the application to the server

The webservice whenever possible

1 - listAll - this service will show all the cities that are registered
in the database

2 - listName - this utility will perform distance calculation and return this
based on the city chosen by the user, the user must report how
parameter the city name and a way of calculating distance of your preference.
The parameter for non-karst use can be: 0 - for KM and 1 - for Miles.

Exemple:

List a city of new York with compare in KM between others cities in database.
http://localhost:8080/webserviceRestFull/city/listName?nameCidade=Nova&unidadeMedida=0

List all cities of database.
http://localhost:8080/webserviceRestFull/city/listAll
