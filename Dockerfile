FROM openjdk:17-jdk-slim

LABEL image.authors="seuemail"

COPY build/libs/ms-product-0.0.1-SNAPSHOT.jar ms-product.jar

ENTRYPOINT ["java", "-jar", "ms-product.jar"]