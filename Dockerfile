FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY /build/libs/demo-0.0.1-SNAPSHOT.jar demo.jar
ENTRYPOINT ["java","-jar","/demo.jar"]