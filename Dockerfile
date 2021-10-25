FROM java:8
RUN mkdir -p /software
ADD /target/Customer-Microservice-0.0.1-SNAPSHOT.jar /software/Customer-Microservice-0.0.1-SNAPSHOT.jar
CMD java -Dserver.port=$PORT $JAVA_OPTS -jar /software/Customer-Microservice-0.0.1-SNAPSHOT.jar

