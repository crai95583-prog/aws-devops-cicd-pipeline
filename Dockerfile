FROM eclipse-temurin:21-jre

WORKDIR /app

COPY app/target/devops-cicd-app-1.0.0.jar app.jar

CMD ["java", "-jar", "app.jar"]
