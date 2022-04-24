FROM openjdk:11

COPY target/smarthouse.jar /smarthouse.jar
EXPOSE 8080
#ADD target/smarthouse.jar /smarthouse.jar
ENTRYPOINT ["java", "-jar", "/smarthouse.jar"]
