FROM eclipse-temurin:17-jdk-alpine

# Add labels for better container management
LABEL org.opencontainers.image.source="https://github.com/Boelgen/boelgen-backend"
LABEL org.opencontainers.image.description="Spring Boot application"
LABEL org.opencontainers.image.licenses="MIT"

# Add non-root user for security
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

WORKDIR /app

# Copy JAR file
COPY --chown=appuser:appgroup build/libs/app-0.0.1-SNAPSHOT.jar app.jar

# Expose application port
EXPOSE 8080

# Run with memory optimization flags
ENTRYPOINT ["java", "-Xms256m", "-Xmx512m", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]
