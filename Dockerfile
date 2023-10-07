FROM openjdk:11

WORKDIR /app

COPY target/demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar

RUN chmod 777 /app

EXPOSE 8080

ENTRYPOINT ["java","-XX:+HeapDumpOnOutOfMemoryError","-Xms1024m","-jar","/app/demo-0.0.1-SNAPSHOT.jar"]