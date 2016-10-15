Chapter 8: Web Application Administration
-----------------------------------------

NOTE: Before using the build script, edit it and modify as required, especially the values of
* tomcat.home             : Set to your Tomcat 6 installation directory 
* tomcat.manager.url      : Set appropriate host/port values in the URL
* tomcat.username         : Tomcat manager role user
* tomcat.password         : Password for Tomcat manager role user

File list
---------

* build.xml               : Example Ant build script for managing web applications with Ant using Tomcat's Ant tasks.
* tomcat-tasks.properties : Property file included by build.xml. Sets the 'taskdef' values for Tomcat's Ant tasks.
* web                     : A very simple, 'hello world' web application example

