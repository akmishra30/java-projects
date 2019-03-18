# Spring boot Redis project
Simple springboot microservice with Redis cache server basic implementation.

**Required Tech-spec :**

	1. Java (v1.8 or later)
	2. Springboot  (v2.0.5.RELEASE)
	3. Eclipse 
	4. Maven 
	5. Redis (v4.0.8 64bit) 
	6. com.h2database (in-memory db)

**Classes, interfaces, entities and exceptions :**

	 - ApplicationStartup : Java class for spring boot application startup
	 - CustomerRestController: Rest controller to handle rest requests
	 - CustomerServiceImpl: Service class with business logic for URL Shorting
	 - RedisRepository: Redis Repository class for cache specific operations
	 - Customer: Customer entity with request payload
	 - UrlResponse: Response entity class
	 - EntityNotFoundException: Exception class if entity not found
	 - InvalidDataException: Exception class if payload is invalid
	 - UrlValidator: Validator class for validating URL
	 - RedisRepository: Redis cache repository for crud operations
	 - RedisH2Repository: H2 DB repository for basic crud operations
	 - application.yml: Service specific configurations
	 - schema.sql: SQL file for table creation
	 - data.sql: SQL file with sample data to be inserted at runtime in H2 DB

**Installing and Starting Redis Server on Mac**

For Redis --**RE**mote **DI**rectory **S**erver-- server setup, I have followed this nice [blog](https://medium.com/@petehouston/install-and-config-redis-on-mac-os-x-via-homebrew-eb8df9a4f298).

To start Redis server  

    redis-server /usr/local/etc/redis.conf

To check server is up or not.  

    redis-cli ping

Redis server connection details  

    URL: http://localhost:6379

**Build project**

    mvn clean build install

**Run project**

    mvn spring-boot:run
    
**Service Rest endpoints**

	POST http://localhost:9090/makhir/api/customer/add
	Request Payload:-
		{
			"name":"XXXXXX",
			"gender": "male",
			"contact":"22222222",
			"email":"abc@test.com"
		}
		
	GET http://localhost:9090/makhir/api/customer/6807118504143567250
	Response:-
		{
		    "id": 6807118504143567250,
		    "name": "XXXXXX",
		    "gender": "male",
		    "contact": "22222222",
		    "email": "abc@test.com"
		}
	
	GET http://localhost:9090/makhir/api/customer/list
	Response:-
		{
		    "data": [
		        {
		            "id": -7207655132083904700,
		            "name": "XXXXXX",
		            "gender": "male",
		            "contact": "22222222",
		            "email": "abc@test.com"
		        },
		        {
		            "id": -6491198635956757767,
		            "name": "XXXXXX",
		            "gender": "male",
		            "contact": "22222222",
		            "email": "abc@test.com"
		        }
		      ],
		    "total": 2
		}
	
	DELETE http://localhost:9090/makhir/api/customer/cache/refresh
	Response:-
		{
		    "total-entity": 14,
		    "message": "All the keys removed successfully from Redis cache."
		}
		
	H2 DB Console:
	http://localhost:9090/makhir/api/h2-console/login.jsp
	