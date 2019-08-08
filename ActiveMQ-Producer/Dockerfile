FROM maven:latest as base
WORKDIR /build
COPY . .
RUN mvn clean package
FROM java:8
WORKDIR /opt/app
COPY --from=base /build/target/ActiveMQ-Producer-0.0.1-SNAPSHOT.jar MSProducer.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "MSProducer.jar"]
