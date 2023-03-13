FROM openjdk:17

COPY ./build/libs/ms.university-0.0.1.jar ms.university-0.0.1.jar

EXPOSE 8080

ENTRYPOINT ["java","-Dspring.profiles.active=local","-jar","/ms.university-0.0.1.jar"]