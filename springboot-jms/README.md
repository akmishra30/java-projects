# springboot-jms project
This is sample project with springboot v2.0.5.RELEASE and jms along ActiveMQ to explore springboot-jms integration.

**Required Tech-spec :**
1. Java (v1.8 or later)
2. Springboot  (v2.0.5.RELEASE)
3. Eclipse 
4. Maven 
5. ActiveMQ (External)  

**Build**

``mvn clean build install``

**Run**

``mvn spring-boot:run``

**Application Endpoint**

``http://localhost:9090/makhir``

**To post message to ActiveMQ queue**

``[POST] http://localhost:9090/makhir/jms/service/message``

    Payload: [Content-Type: application/json]
    {
	"queue":"message.queue",
	"payload":"This is sample jms message."
    }

