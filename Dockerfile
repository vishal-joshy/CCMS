FROM amazoncorretto:17-alpine3.18-jdk

WORKDIR /project

CMD ["./gradlew","bootRun"]

EXPOSE 8080
