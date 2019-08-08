FROM maven:latest as base
WORKDIR /build
COPY . .
RUN mvn clean package
FROM java:8
WORKDIR /opt/app
COPY --from=base /build/target/Micro-Service-Prize_Gen-0.0.1-SNAPSHOT.jar MSPrizeGen.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "MSPrizeGen.jar"]
