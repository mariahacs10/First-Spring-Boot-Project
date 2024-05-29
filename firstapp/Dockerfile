FROM maven:3.8.5-openjdk-17
COPY ..
COPY mvnw
RUN mvnw clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/firstapp-0.0.1-SNAPSHOT.jar firstapp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","firstapp.jar"]