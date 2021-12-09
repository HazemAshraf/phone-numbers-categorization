FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/phone-numbers-categorization.jar phone-numbers-categorization.jar
ENTRYPOINT ["java","-jar","/phone-numbers-categorization.jar"]