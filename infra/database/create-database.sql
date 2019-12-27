	cd C:\Program Files\PostgreSQL\9.6\bin>
	psql -U postgres
	create database bd_coder_blog with owner=postgres encoding='utf8';
	template1=# create user usr_coder_blog with password 'pwd_coder_blog';
	CREATE ROLE
	template1=# create database bd_coder_blog;
	CREATE DATABASE
	template1=# grant ALL on DATABASE bd_coder_blog to usr_coder_blog;
	GRANT
	template1=# \q	
	
	
	
	spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/bd_coder_blog?createDatabaseIfNotExist=true
spring.datasource.username=postgres
spring.datasource.password=1q2w3e
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults=false