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

**Installing Redis server on Docker**  
Here, I'm considering that you have already installed the docker on your local server and it's up and running. Now the case is to install Redis service on running Docker. For my case, I'm using MacOS and already installed the docker on my mac.  

The command is to download the redis server and installed it on docker server.

	docker run --name my-redis -p 6379:6379 --restart always --detach redis
Few more important docker command for your Redis server. 

	$docker —help				# This is for listing all the docker commands
	$docker container ls			# This is for listing all the running container in docker
	$docker start <container_name> 		# This is for starting specific container
	$docker stop <container_name>		# This is for stopping specific container
	$docker logs --follow my-redis		# This command shows running logs of given container
	$docker container inspect my-redi	# This command helps to detailed information of the container
	$docker stats my-redis			# This is command helps to extract the current memory/cpu usage for given container
	
	
	
	
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
		            "id": -3313488897161316244,
		            "name": "Ashish",
		            "gender": "Male",
		            "contact": "3453454546",
		            "email": "abc@test.com",
		            "createdTime": "2019-03-23T21:08:28.766"
		        },
		        {
		            "id": 5755742716097921146,
		            "name": "Ashish",
		            "gender": "Male",
		            "contact": "3453454546",
		            "email": "abc@test.com",
		            "createdTime": "2019-03-23T21:08:27.215"
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
	