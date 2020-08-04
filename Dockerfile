FROM openjdk:13-alpine
WORKDIR /
ADD build/libs/Bootcamp2020-Java.jar Bootcamp2020-Java.jar
CMD ["java", "-jar", "Bootcamp2020-Java.jar", "--port=$PORT"]
