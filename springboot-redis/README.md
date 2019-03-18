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
	 - RestUrlShortner: Rest controller to handle events for URL Shortner
	 - UrlShortnerService: Service class with business logic for URL Shorting
	 - RedisRepository: Redis Repository class for cache specific operations
	 - UrlEntity: URL entity with request payload
	 - UrlResponse: Response entity class
	 - InvalidUrlException: Exception class if invalid URL received in request
	 - UrlNotFoundException: Exception class if URL doesn't available in cache
	 - UrlValidator: Validator class for validating URL

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