# Use a base image with Java 17
FROM eclipse-temurin:17-jdk-jammy as builder

# Set the working directory in the container
WORKDIR /app

# Copy only the necessary files to the container
COPY build.gradle .
COPY settings.gradle .
COPY gradlew .
COPY gradle ./gradle
COPY src ./src

# Download Gradle (if not already cached)
RUN ./gradlew --no-daemon build

# Use a smaller base image for the runtime environment
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory in the container
WORKDIR /app

# Copy the compiled Spring Boot application JAR file from the builder stage
COPY --from=builder /app/build/libs/*.jar /app/application.jar

# Expose the port that your Spring Boot application uses (default is 8080)
EXPOSE 8080

# Command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "application.jar"]