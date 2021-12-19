FROM openjdk:11
VOLUME /tmp
EXPOSE 8094
ADD ./target/api-man-socios-mongodb-0.0.1-SNAPSHOT.jar api-man-socios-mongodb.jar
ENTRYPOINT ["java","-jar","/api-man-socios-mongodb.jar"]