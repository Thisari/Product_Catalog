Product Catalog Web Application

Product Catalog Service is developed using Spring Boot Framework and user identity & access management is done using KeyCloak.

How to set-up

1.Clone the repository.


2.Run the DB Script and Triggers Scripts in the ‘db-scripts’ folder.


3.Extract the KeyCloak zip file.


4Run ‘standalone.bat’ or ‘standalone.ssh’ inside the bin folder(KeyCloak server can be accessed via localhost:8080). 

NOTE: Predefined users are added
		

Account -> Admin account(KeyCloak)

UserName: admin

Password: admin


Account -> Admin user(product-catalog-app)

UserName: savi

Password: 123


Account -> Data Entry user(product-catalog-app)

UserName: thisa

Password:123



5.Spring Boot service can be run using the ‘spring-boot-service’ folder.

NOTE:update the relevant DB credentials in application.properties file.

spring.datasource.url= jdbc:mysql://localhost:3306/product_catalog_db
spring.datasource.username= root
spring.datasource.password= 123


6.Once the service is up all the APIs can be executed via Swagger.
Swagger URL - http://localhost:5002/catalog-app/swagger-ui.html#/
	NOTE: For the authentication use KeyCloak credentials(savi)


