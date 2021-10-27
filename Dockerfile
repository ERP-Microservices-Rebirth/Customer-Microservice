FROM java:8
EXPOSE 8089
ADD /target/Customer-Microservice-0.0.1-SNAPSHOT.jar customer-microservice.jar
ENTRYPOINT [ "java", "-jar", "customer-microservice.jar" ]

