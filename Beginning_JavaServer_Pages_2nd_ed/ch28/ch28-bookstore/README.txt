Chapter 28 - Example Application Readme
=================================================================
These instructions assume you have set up Ant and Tomcat on your computer. It also assumes you have downloaded and installed the following:

Hibernate 2.1.4          - http://www.hibernate.org
Struts 1.2.4             - http://struts.apache.org
MySQL JDBC Driver 3.0.14 - http://www.mysql.com
Jakarta Taglibs          - http://jakarta.apache.org

These instructions help you to establish the build environment for this application. The Chapter itself also explains steps you will have to complete in order to get this application completely working.

Instructions
------------

1. Extract the contents of this zip file into a directory on your computer, for example C:\ch28-bookstore

2. Modify the C:\ch28-bookstore\build.xml file as follows:
   a. Modify the value of the catalina.home property to reflect the location of Tomcat on your computer.
   b. Modify the value of the manager.url property to reflect the URL of the manager application the Tomcat instance you will be deploying this project too.
   c. Modify the values of the manager.username and manager.password properties to reflect the correct values for your instance of Tomcat.

3. The build.xml file contains references to resources you need to have installed on your computer. The script stores a reference to the location where you installed these resources. Sometimes the directory structure of an installation can change from version to version. If you choose to use a different version
to that recommended in the book, please ensure that the build.xml file looks in the appropriate directory for the resources it needs. For instance the script stores the location of the Struts Framework on your computer with: 

  <property name="struts.home" value="f:/java/tools/jakarta-struts-1.2.4"/>

And further on in the script it uses this location to find the resources it needs:

  <property name="struts.jar" value="${struts.home}/lib/struts.jar"/>

The second set property assumes the directory structure of where the resources are located. If you use a different version than what is recommended this location may be different.

You will need to modify the build.xml to suit your computer in the following ways:

    a. Change the value of the jstl.home property to reflect the location of Jakarta Taglib.
    b. Change the value of the struts.home property to reflect the location of Struts Framework 1.2.4
    c. Change the value of the hibernate.home property to reflect the location of Hibernate 2.1.4
    d. Change the value of the mysqljdbc.home property to reflect the location of the MySQL JDBC driver
       installation.

3. Start Tomcat.

4. Open a DOS prompt or Unix command shell to the directory containing the build.xml file
(C:\ch28-bookstore\).

5. Type the following at the prompt: 
   ant install

6. The application should now be available for browsing at http://localhost:8080/bookstore
