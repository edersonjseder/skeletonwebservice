# Skeleton Webservice RESTful in Spring REST, Spring Boot, Spring MVC, JPA and MySQL

Here you will find a small project that aims to expose a REST service to list cities.

It was developed in Java 8 (1.8.0) and uses Tomcat 8.5 to deploy the application. The RESTFull service
Data manipulation layer is made with Spring Rest Framework. It's used 
Spring 4 MVC for DI, JPA as persistence layer with Maven as our dependency manager and MySQL 
Database for the entities.

There are some scripts for MySQL with some inserts of a few entries in each table and the creation of the Schema, which is necessary. The application creates 
the tables and its relationships

# Proposed exercise

 <i><b>The purposes of this project:</b></i>

* Creates Entity classes of Department, Permission and User for the tables and its proper relationships

* The Data manipulation layer uses Spring Data framework and JPA with MySQL database.

* It uses Dependency Injection of Spring Framework to instanciate the service classes

* Uses Spring Rest Framework to create GET, POST, PUT and DELETE operations to manipulate
the data and return them as a JSON object.

* I used the chrome app Postman to test all the CRUD operations.

<i><b>The Deployment of this project:</b></i>

The .war file is attached with this project. And also can be done using eclipse by following these steps:
<ol>
<li>Right click on the location project folder</li>
<li>Running the menu <i><b> > Run > As > Maven install</b></i></li><br/> 

<i>

Expected Result:<br/> 
Results :<br/> <br/> 

[INFO] Scanning for projects...<br/>
[INFO]<br/>                                                                         
[INFO] ------------------------------------------------------------------------<br/>
[INFO] Building webproject Maven Webapp 0.0.1-SNAPSHOT<br/>
[INFO] ------------------------------------------------------------------------<br/>
[INFO] <br/>
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ webproject ---<br/>
[INFO] Using 'UTF-8' encoding to copy filtered resources.<br/>
[INFO] Copying 1 resource<br/>
[INFO] Copying 0 resource<br/>
[INFO] <br/>
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ webproject ---<br/>
[INFO] Nothing to compile - all classes are up to date<br/>
[INFO] <br/>
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ webproject ---<br/>
[INFO] Using 'UTF-8' encoding to copy filtered resources.<br/>
[INFO] skip non existing resourceDirectory /root/workspace/webproject/src/test/resources<br/>
[INFO] <br/>
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ webproject ---<br/>
[INFO] Changes detected - recompiling the module!<br/>
[INFO] <br/>
[INFO] --- maven-surefire-plugin:2.18.1:test (default-test) @ webproject ---<br/>
[INFO] <br/>
[INFO] --- maven-war-plugin:2.5:war (default-war) @ webproject ---<br/>
[INFO] Packaging webapp<br/>
[INFO] Assembling webapp [webproject] in [/root/workspace/webproject/target/webproject]<br/>
[INFO] Processing war project<br/>
[INFO] Copying webapp resources [/root/workspace/webproject/src/main/webapp]<br/>
[INFO] Webapp assembled in [311 msecs]<br/>
[INFO] Building war: /root/workspace/webproject/target/webproject.war<br/>
[INFO] <br/>
[INFO] --- maven-install-plugin:2.5.2:install (default-install) @ webproject ---<br/>
[INFO] Downloading: https://repo.maven.apache.org/maven2/commons-codec/commons-codec/1.6/commons-codec-1.6.pom<br/>
[INFO] Downloaded: https://repo.maven.apache.org/maven2/commons-codec/commons-codec/1.6/commons-codec-1.6.pom (11 KB at 6.2 KB/sec)<br/>
[INFO] Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-utils/0.4/maven-shared-utils-0.4.pom<br/>
[INFO] Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-utils/0.4/maven-shared-utils-0.4.pom (4 KB at 9.4 KB/sec)<br/>
[INFO] Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.0.15/plexus-utils-3.0.15.pom<br/>
[INFO] Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.0.15/plexus-utils-3.0.15.pom (4 KB at 7.3 KB/sec)<br/>
[INFO] Downloading: https://repo.maven.apache.org/maven2/commons-codec/commons-codec/1.6/commons-codec-1.6.jar<br/>
[INFO] Downloaded: https://repo.maven.apache.org/maven2/commons-codec/commons-codec/1.6/commons-codec-1.6.jar (228 KB at 211.1 KB/sec)<br/>
[INFO] Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-utils/0.4/maven-shared-utils-0.4.jar<br/>
[INFO] Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-utils/0.4/maven-shared-utils-0.4.jar (152 KB at 284.3 KB/sec)<br/>
[INFO] Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.0.15/plexus-utils-3.0.15.jar<br/>
[INFO] Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-utils/3.0.15/plexus-utils-3.0.15.jar (234 KB at 372.8 KB/sec)<br/>
[INFO] Installing /root/workspace/webproject/target/webproject.war to /root/.m2/repository/com/skeleton/webproject/0.0.1-SNAPSHOT/webproject-0.0.1-SNAPSHOT.war<br/>
[INFO] Installing /root/workspace/webproject/pom.xml to /root/.m2/repository/com/skeleton/webproject/0.0.1-SNAPSHOT/webproject-0.0.1-SNAPSHOT.pom<br/>
[INFO] ------------------------------------------------------------------------<br/>
[INFO] BUILD SUCCESS<br/>
[INFO] ------------------------------------------------------------------------<br/>
[INFO] Total time: 11.612 s<br/>
[INFO] Finished at: 2017-04-18T00:34:13-04:00<br/>
[INFO] Final Memory: 21M/202M<br/>
[INFO] ------------------------------------------------------------------------<br/> 
The .war file will be in the <i>target</i> folder of the project (in my case, in <i><b>/root/workspace/location/target</b></i>)
</i>
<li>Stop the Tomcat Server service</li>
<li>To deploy in Tomcat 8 server, copy the .war file in the webapps in <i>tomcat directory</i> (<i><b>your_host/tomcat/apache-tomcat-8.5.13/webapps</b></i> the menu <i><b> > Run > As > Maven install</b></i>)</li><br/> 
<li>Restart the Tomcat Server service and test the .war using the browser with the URL: http://your_ip:8080/location/rest/cities/city (can be the default localhost:8080)</li>
<li>After you have it deployed (check the /logs dir for any problems), it should be accessible via: <u><i>http://your_host:your_port/location/rest/cities/city</i></u>. Or in the default, one of those:<br/>
<u><i>http://the_ip:the_port/skeleton/v1/departments</i></u>
<u><i>http://the_ip:the_port/skeleton/v1/permissions</i></u><br/>
<u><i>http://the_ip:the_port/skeleton/v1/users</i></u><br/>
</li>
</ol>

<i><b>The Database usage of this project:</b></i>

The database is MySQL Database 5 and it's used the following credentials to access:<p>
<p><b>Username:</b> <i>root</i><br/>
<p><b>Password:</b> <i>a</i><br/>
<p><b>Schema:</b> <i>aroundinfo</i><br/>
<p><b>Url:</b> <i>jdbc:mysql://localhost:3306/skeletoninfo</i><br/>

And can be changed at the <i>connection.properties</i> file in the .war file to better attend portability. Please change for the proper database.

<i><b>The SQL Scripts usage of this project:</b></i>

Attached it will have a SQL script file with the creation of the tables for testing, and the insertion of some data for testing as well
