# Use the official OpenJDK image as the base image
FROM openjdk:11

# Set the working directory in the container
WORKDIR /app

# Copy the Maven wrapper and project files to the container
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Copy the project source code to the container
COPY src ./src

# Build the Spring Boot application using Maven
RUN ./mvnw clean package

# Expose the port on which your application will run
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "target/firstapp-0.0.1-SNAPSHOT.jar"]