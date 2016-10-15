Chapter 27 - JSP Portal
=================================================================
These instructions assume you have set up Ant and Tomcat on your computer. For your convenience, the jar files for all other dependencies, such as Apache Axis, Rome RSS library, Struts, JSTL, are already packaged with the web application

These instructions help you to establish the build environment for this application. The Chapter itself also explains steps you will have to complete in order to get this application completely working.

Instructions
------------

1. Extract the contents of this zip file into a directory on your computer, for example C:\ch27

2. Modify the C:\ch27\build.xml file as follows:
   a. Modify the value of the catalina.home property to reflect the location of Tomcat on your computer.

3. Note that you need to get a Amazon associate’s id (the default is webservices-20), and a developer token for the examples.
   Once you get these, modify com.wrox.begjsp.ch27.wsproxy.AmazonStore.java appropriately.
    
4. Build the source code
    $ ant dist    

5. Start Tomcat and deploy the web application WAR file from C:\ch27\dist

6. The application should now be available for browsing at http://localhost:8080/ch27
