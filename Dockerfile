FROM openjdk:17

WORKDIR /project
RUN microdnf install findutils
