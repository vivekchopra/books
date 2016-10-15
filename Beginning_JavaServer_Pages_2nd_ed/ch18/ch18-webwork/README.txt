Chapter 18 - Webwork - Examples Readme.
=================================================================
These instructions assume you have set up Ant and Tomcat on your 
computer.

1. Extract the contents of this zip file into a directory on your computer, for example
C:\ch18-webwork

2. Open a DOS prompt or Unix command shell to the directory containing the build.xml file
(C:\ch18-webwork\webwork-skeleton\).

3. Type the following at the prompt: 
	
	ant compile

4. Start Tomcat.

5. Using the Manager application in Tomcat create a new context pointing to the
c:\ch18-webwork\webwork-skeleton directory. Give the context a URL alias of webwork.

6. The application should now be available for browsing at http://localhost:8080/webwork

