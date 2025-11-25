# -----------------------
# 1. BUILD STAGE
# -----------------------
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app

# Copy Maven wrapper and project files
COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml .

# Pre-download dependencies (good for rebuild speed)
RUN ./mvnw dependency:go-offline -B

# Copy the actual source
COPY src ./src

# Build the Spring Boot jar
RUN ./mvnw clean package -DskipTests

# -----------------------
# 2. RUNTIME STAGE
# -----------------------
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy built jar
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
