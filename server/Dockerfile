FROM openjdk:14.0.2

ARG MODULE_NAME=server
ARG APPLICATION_NAME=bookstore

COPY build/libs/${MODULE_NAME}-*-boot.jar /var/$APPLICATION_NAME/app.jar

WORKDIR /var/${APPLICATION_NAME}
ENTRYPOINT ["java", "-jar", "app.jar"]
