Chapter 20 - Examples Readme.
=================================================================
These instructions assume you have set up Ant and Tomcat on your computer. It also
assumes you have downloaded and installed the following packages:

From Jakarta (http://jakarta.apache.org/):

Commons Collections 2.1.1
Commons BeanUtils 1.6.1
Commons Digester 1.5
Jakarta Taglibs

From the Tiles site (http://www.lifl.fr/~dumoulin/tiles/index.html):

Tiles

Instructions
------------

1. Extract the contents of this zip file into a directory on your computer, for example
C:\ch20-tiles-examples

2. Modify the C:\ch20-tiles-examples\build.xml file as follows:
	a. Modify the value of the catalina.home property to reflect the location of Tomcat on your computer.
	b. Modify the value of the manager.url property to reflect the URL of the manager application the Tomcat instance you will be deploying this project too.
	c. Modify the values of the manager.username and manager.password properties to reflect the correct values for your	instance of Tomcat.
	
3. The build.xml file contains references to resources you need to have installed on your computer. The
script stores a reference to the location where you installed these resources. Sometimes the directory
structure of an installation can change from version to version. If you choose to use a different version
to that recommended in the book, please ensure that the build.xml file looks in the appropriate directory
for the resources it needs. For instance the script stores the location of the Tiles Framework on your
computer with: 

<property name="tiles.home" value="e:/java/tools/tiles"/>

And further on in the script it uses this location to find the resources it needs:

<property name="tiles.jar" value="${tiles.home}/lib/tiles.jar"/>

The second set property assumes the directory structure of where the resources are located. If you use a different version than what is recommended this location may be different.

You will need to modify the build.xml to suit your computer in the following ways:

	a. Change the value of the tiles.home property to reflect the location of Tiles.
    b. Change the value of the collections.home property to reflect the location of Commons Collections	2.1.1
  	c. Change the value of the beanutils.home property to reflect the location of Commons BeanUtils 1.6.1
    d. Change the value of the digester.home property to reflect the location of Commons Digester 1.5
    e. Change the value of the jstl.home property to reflect the location of Jakarta Taglibs

3. Start Tomcat.

4. Open a DOS prompt or Unix command shell to the directory containing the build.xml file
(C:\ch20-tiles-examples\).

5. Type the following at the prompt: 
	
	ant install

6. The application should now be available for browsing at http://localhost:8080/tiles
