URLS:

GET=
http://localhost:8081/demorest/webapi/aliens/
http://localhost:8081/demorest/webapi/aliens/singleAlien/1

To send data in json format use jersey-media-json-binding in pom.xml

POST=
http://localhost:8081/demorest/webapi/aliens/createAlien

Create an actual database using MySQL and add dependancy in pom.xml using:
https://mvnrepository.com/artifact/mysql/mysql-connector-java

create database restdb;
use restdb;
create table alien(id int,name varchar(20),points int,hobby varchar(20));
select * from alien;


UPDATE=
http://localhost:8081/demorest/webapi/aliens/updateAlien


DELETE=
http://localhost:8081/demorest/webapi/aliens/deleteAlien/2